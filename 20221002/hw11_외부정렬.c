/*                                                           */
/*  EXTSORT.C  :  External Sort Alogorithm Test              */
/*                                                           */
/*                  Programmed By Lee jaekyu                 */
/*                                                           */
/* partly modified by jsahn */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <io.h>//리눅스 환경에서 사용 x
#include <memory.h>

#define BUFSIZE  4096

typedef int (*FCMP)(const void*, const void*);
typedef void (*ESFNC)(FILE*, FILE*, size_t, void*, size_t, FCMP);

int intcmp(const void* a, const void* b)
{
    return (*(int*)a - *(int*)b);
}

void shell_sort(void* base, size_t nelem, size_t width, FCMP fcmp)
{
    int i, j, k, h;
    void* v;
    v = malloc(width);
    for (h = 1; h < nelem; h = 3 * h + 1);
    for (h /= 3; h > 0; h /= 3)
    {
        for (i = 0; i < h; i++)
        {
            for (j = i + h; j < nelem; j += h)
            {
                memcpy(v, (char*)base + j * width, width);
                k = j;
                while (k > h - 1 && fcmp((char*)base + (k - h) * width, v) > 0)
                {
                    memcpy((char*)base + k * width, (char*)base + (k - h) * width, width);
                    k -= h;
                }
                memcpy((char*)base + k * width, v, width);
            }
        }
    }
    free(v);
}

struct entry
{
    FILE* fp;
    char fname[13];
    void* v;
    int is_eof;
};

void external_sort(FILE* src, FILE* dst, size_t width,
    void* buf, size_t buflen, FCMP fcmp)
{
    int i, minindex, done;
    int nelem, nbuf, nfile;
    void* min;
    struct entry* tmp;

    min = malloc(width);

    fseek(src, 0L, SEEK_END);
    nelem = (int)(ftell(src) / width);
    nbuf = buflen / width;
    nfile = nelem / nbuf + 1;

    tmp = (struct entry*)malloc(sizeof(struct entry) * nfile);
    for (i = 0; i < nfile; i++)
    {
        //sprintf_s(tmp[i].fname,13, "%d.TMP", i);
        sprintf(tmp[i].fname, "%d.TMP", i);
        tmp[i].fp = fopen(tmp[i].fname, "wb+");
        tmp[i].v = malloc(width);
        tmp[i].is_eof = 0;
    }

    fseek(src, 0L, SEEK_SET);
    for (i = 0; i < nfile - 1; i++)
    {
        int ne;

        fread(buf, width, nbuf, src);
        shell_sort(buf, nbuf, width, fcmp);
        ne = fwrite(buf, width, nbuf, tmp[i].fp);

        printf("\n Reading & Sorting & Writing %s.", tmp[i].fname);
    }
    fread(buf, width, nelem % nbuf, src);
    shell_sort(buf, nelem % nbuf, width, fcmp);
    fwrite(buf, width, nelem % nbuf, tmp[i].fp);

    printf("\n Reading & Sorting & Writing %s.", tmp[i].fname);

    for (i = 0; i < nfile; i++)
    {
        rewind(tmp[i].fp);
        if (fread(tmp[i].v, width, 1, tmp[i].fp) == 0)
            tmp[i].is_eof = 1;
    }
    rewind(dst);

    printf("\n Now merging...");

    while (1)
    {
        done = 1;
        for (i = 0; i < nfile; i++)
            if (!tmp[i].is_eof) done = 0;
        if (done) break;
        i = 0;
        while (tmp[i].is_eof) i++;
        minindex = i;
        memcpy(min, tmp[minindex].v, width);
        while (++i < nfile)
        {
            if (!tmp[i].is_eof && fcmp(min, tmp[i].v) > 0)
            {
                minindex = i;
                memcpy(min, tmp[i].v, width);
            }
        }
        fwrite(tmp[minindex].v, width, 1, dst);
        if (fread(tmp[minindex].v, width, 1, tmp[minindex].fp) == 0)
            tmp[minindex].is_eof = 1;
    }

    for (i = 0; i < nfile; i++)
    {
        fclose(tmp[i].fp);
        unlink(tmp[i].fname);//중간 파일 삭제하지 않고 남겨둘시 이 코드 삭제
        free(tmp[i].v);
    }
    free(min);
    free(tmp);
}

int main()
{
    long t1, t2, t;
    void* buf;
    FILE* src, * dst;
    char* fn = "RANDOM.DAT";
    int i;
    if ((buf = malloc(BUFSIZE)) == NULL)
    {
        printf("Out of memory");
        exit(1);
    }

    if ((src = fopen(fn, "rb")) == NULL)
    {
        printf("\nDisk Error!");
        exit(1);
    }

    if ((dst = fopen("RESULT.DAT", "wb+")) == NULL)
    {
        printf("\nDisk Error!");
        exit(1);
    }
    external_sort(src, dst, sizeof(int), buf, BUFSIZE, intcmp);
    fclose(src);
    fclose(dst);
    free(buf);
}

//3-2 
/*
기존 함수 외부정렬함수->width만큼 버퍼 생성, 한개씩 읽어와 리턴
*/

//3-3
/*
정렬할 원소의 개수, 입력 파일의 개수-> 중간파일의 개수는 원소의 개수/메인 메모리에서 한번에 접근할 수 있는 원소의 수
*/