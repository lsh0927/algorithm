#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define STR_MAX 200
#define SUB_MAX 11 //학생의 수
#define MAX 100000
//학생의 정보를 파일에서 읽어, 구조체의 배열에 저장하며, 학과와 학번의 오름차순으로 힙 정렬
// 학과가 우선시됨. 이름과 학과명은 빈 칸 없는 한 단어이며, 학과명의 정렬시 대소문자 구분x
// 결과를 <입력화일명>.out에 저장
// 강의 자료의 heap함수를 사용하였으며, char형과 int형을 사용하기 위해 적절히 수정하였습니다.

typedef struct {
	char sub[11]; //학과(data[0]은 MAX값을 넣어줘야함)
	char name[11]; //이름(마찬가지)
	char id[11]; //학번(비교시 배열이 필요없으므로 선언하지 않음)
} student;

student data[50];

void t_heap_sort(student a[], int n); //학과를 정렬할 함수
void upheap(student a[], int k);
void downheap(student a[], int n, int k);
void print_aarray(student* a);

char* ctemp; //sub(학과)를 대소문자 구분없이 사용하기 위한 전역변수(포인터)
char* ptr; //ctemp= strlwr(ptr)로 받아 정렬한뒤 .out파일에 저장할 땐 ptr로 저장할 것임.
char* rtemp; //학과가 같을때 학번을 비교하기 위해 임시로 가리킬 학과

int main(void)
{
	int n;
	FILE* fp;
	fp = fopen("student(2).txt", "r");
	
	char s[STR_MAX];
	int i = 1;
	
	while (fgets(s, sizeof(s), fp) != NULL) {
			
		ptr = strtok(s, " "); //띄어쓰기가 된 부분으로 나눔. ptr 포인터가 이를 가르킴
		strcpy(data[i].name,ptr); // 이름을 저장. data[0].name은 비어있고 그 뒤부터 저장.(data[0].sub와 id도 비어있음)
		
		ptr = strtok(NULL, " "); //ptr에 id가 문자형으로 들어옴 "21345678"같은 식으로
		strcpy(data[i].id, ptr);
		//data[i].id=atoi(ptr); //atoi함수로 string to int. data[0].id는 비어있음 
					
		ptr = strtok(NULL, " ");// 그 다음부터 공백문자를 띄어 sub에 저장
		//ctemp = strlwr(ptr); 대소문자 구분없이 정렬하기 위해, 전역변수 문자열 포인터를 선언해서 일단 소문자로 바꿔줌. 후에 파일에 
		//저장할때는 원래 포인터인 ptr를 저장할 것임.
		
		strcpy(data[i].sub, ptr); //sub저장, data[0].sub도 비어있음
		i++;
		
	}
	strcpy(data[0].name, "zzzzzzzzzz");
	strcpy(data[0].id , "999999999");
	strcpy(data[0].sub, "zzzzzzzzzz");

	t_heap_sort(data, SUB_MAX);
	print_aarray(data);
	
	

	for (int sibal = 1; sibal <=50; sibal++)
	{
		FILE* fpw = fopen("student(2).txt.out", "w");
		char buffer[MAX] = { fp };

	}

	//data배열을 파일에 <입력파일명>.out으로 저장. -> 저장할때 원래 대문자는 다시 복구시켜야 대

	fclose(fp);
	return 0;
}


void t_heap_sort(student data[], int n) {//char형  학과를 비교, 여기서 비교가 되지 않으면 학번으로 넘어감
	int i;
	student h;
	char temp6[11];
	char temp7[11];
	

	printf("\nHeap Sort top-down construction\n\n");
	for (i = 2; i <= n; i++)
	{
		upheap(data, i);
		
	}
	
	for (i = n; i > 1; i--) {

		student temp = data[1]; //구조체 배열이므로 각 항목(sub,name,id)를 바꾸는 것이 아니라 구조체 배열 자체를 교환
		data[1] = data[i];
		data[i] = temp;
		downheap(data, i - 1, 1);
	}
	

	for (int b = 1; b < SUB_MAX + 1; b++)
	{
		strcpy(temp6, data[b].sub);
		strcpy(temp7, data[b + 1].sub);
		if (strcmp(strlwr(temp6), strlwr(temp7)) == 0)
		{
			if (strcmp(data[b].id, data[b + 1].id)>0)
			{
				h = data[b + 1];
				data[b + 1] = data[b];
				data[b] = h;
			}
		}
	}
}

void upheap(student data[], int k) {
	student v;
	v = data[k]; //비교를 통해 swap할 배열을 선택함
	char temp1[11];
	strcpy(temp1,data[k / 2].sub);
	char temp2[11];
	strcpy(temp2, v.sub);

	
	while (strcmp(strlwr(temp1), strlwr(temp2)) <= 0) //비교 항목은 구조체 배열의 학과
	{
		data[k] = data[k / 2];
		k /= 2;
		strcpy(temp1,data[k/2].sub);
		
	}
	data[k] = v;
}

void downheap(student data[], int n, int k) {
	int	i, c;
	student f;//힙정렬을 위한 변수
	f = data[k];
	char temp3[11];
	char temp4[11];
	char temp5[11];

	while (k <= n / 2) {
		i = k << 1;

		strcpy(temp3, data[i].sub);
		strcpy(temp4, data[i + 1].sub);
		strcpy(temp5, f.sub);

		if (i < n && strcmp(strlwr(temp3), strlwr(temp4)) < 0)
		{
			i++;
			strcpy(temp3, data[i].sub);
		}
		if (strcmp(strlwr(temp5), strlwr(temp3)) >= 0)
			break;
		data[k] = data[i];
		k = i;
	}
	data[k] = f;


}


void print_aarray(student* a)
{
	int i;
	for (int i = 1; i < SUB_MAX + 1; i++)
		printf("%s %s %s\n", a[i].name, a[i].id, a[i].sub); //출력할때 구조체가 완전히 바뀌지 않았다는 의미
}



