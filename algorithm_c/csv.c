#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 300
#define MAX_SIZE 1000
#define MAX_LINE_SIZE 256

typedef struct _hscPerson {
    char first_name[20];
    char second_name[20];
    int age;
    char email[40];
    char company[40];
} hscPerson;

typedef struct _hscTable {
    hscPerson name[TABLE_SIZE];
} hscTable;

unsigned int samehsc(int index, int isFull) {
    return (index + isFull) % TABLE_SIZE;
}

int h1_func(char* email) {
    int h = 0;
    while (*email != '@') {
        h += *email;
        *email++;
    }
    return h % TABLE_SIZE;
}

int h2_func(int age) {
    return age % TABLE_SIZE;
}

void inserthsc(hscTable* table, hscPerson* hscp) {
    int h1 = h1_func(hscp->email);
    int h2 = h2_func(hscp->age);
    int isFull = 0;

    while (table->name[h1].email[0] != '\0') {
        isFull++;
        h1 = samehsc(h1, isFull * h2);
    }
    table->name[h1] = *hscp;
}

void searchhsc(hscTable* table, char* email, int age) {
    int h1 = h1_func(email);
    int h2 = h2_func(age);
    int isFull = 0;

    while (table->name[h1].email[0] != '\0') {
        if (strcmp(table->name[h1].email, email) == 0 && table->name[h1].age == age) {
            printf("-> 데이터를 찾았습니다: %s,%s,%d,%s,%s\n", table->name[h1].first_name,
                table->name[h1].second_name, table->name[h1].age,
                table->name[h1].email, table->name[h1].company);
            return;
        }

        isFull++;
        h1 = samehsc(h1, isFull * h2);
    }

    printf("-> 데이터가 없습니다.\n");
}

void removehsc(hscTable* table, char* email, int age) {
    int index = h1_func(email);
    int step = h2_func(age);
    int isFull = 0;

    while (table->name[index].email[0] != '\0') {
        if (strcmp(table->name[index].email, email) == 0 && table->name[index].age == age) {
            printf("-> 데이터를 삭제하였습니다: %s,%s,%d,%s,%s\n", table->name[index].first_name,
                table->name[index].second_name, table->name[index].age,
                table->name[index].email, table->name[index].company);
            table->name[index].email[0] = '\0';
            return;
        }

        isFull++;
        index = samehsc(index, isFull * step);
    }

    printf("-> 데이터가 없습니다.\n");
}

int main() {
    FILE* file;
    char line[MAX_LINE_SIZE];
    char fname[20];
    printf("파일명입력\n");
    scanf("%s", fname);

    // 파일 열기
    file = fopen(fname, "r");
    if (file == NULL) {
        printf("파일을 열 수 없습니다.");
        return 1;
    }

    hscPerson hscp;
    hscTable table;

    // 한 줄씩 파일 읽기
    while (fgets(line, MAX_LINE_SIZE, file) != NULL) {
        char* token = strtok(line, ",");
        strcpy(hscp.first_name, token);

        token = strtok(NULL, ",");
        strcpy(hscp.second_name, token);

        token = strtok(NULL, ",");
        strcpy(hscp.email, token);

        token = strtok(NULL, ",");
        hscp.age = atoi(token);

        token = strtok(NULL, ",");
        strcpy(hscp.company, token);

        inserthsc(&table, &hscp);
    }

    // 파일 닫기
    fclose(file);

    char email[MAX_LINE_SIZE];
    int age;
    int choice;
    hscPerson newPerson;

    printf("데이터를 모두 저장하였습니다.\n");

    while (1) {
        printf("무엇을 원하십니까? 1:삽입 2:삭제 3:검색, 4:종료 -> ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:  // 삽입
            printf("First name: ");
            scanf("%s", newPerson.first_name);

            printf("Second name: ");
            scanf("%s", newPerson.second_name);

            printf("이메일: ");
            scanf("%s", newPerson.email);

            printf("나이: ");
            scanf("%d", &newPerson.age);

            printf("회사명: ");
            scanf("%s", newPerson.company);

            inserthsc(&table, &newPerson);
            printf("-> 데이터를 추가하였습니다.\n");

            break;

        case 2:  // 삭제
            printf("이메일: ");
            scanf("%s", email);

            printf("나이: ");
            scanf("%d", &age);

            removehsc(&table, email, age);
            break;

        case 3:  // 검색
            printf("이메일: ");
            scanf("%s", email);

            printf("나이: ");
            scanf("%d", &age);

            searchhsc(&table, email, age);
            break;

        case 4:  // 종료
            printf("Bye~\n");
            exit(0);

        default:
            printf("올바르지 않은 선택입니다. 다시 선택하세요.\n");
        }
    }

    return 0;
}
