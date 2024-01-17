#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 300
#define MAX_LINE_SIZE 256

// 구조체 정의: 이름, 성, 나이, 이메일, 회사명
struct Person {
    char firstName[MAX_LINE_SIZE];
    char secondName[MAX_LINE_SIZE];
    int age;
    char email[MAX_LINE_SIZE];
    char company[MAX_LINE_SIZE];
};

// 해시 테이블 구조체 정의
struct HashTable {
    struct Person data[TABLE_SIZE];
};

// 해시 함수 정의
unsigned int hash(char *email) {
    unsigned int hash = 0;
    while (*email) {
        hash = (hash * 31) + *email;
        email++;
    }
    return hash % TABLE_SIZE;
}

// 데이터 삽입 함수
void insert(struct HashTable *table, struct Person *person) {
    unsigned int index = hash(person->email);

    // 데이터 복사
    table->data[index] = *person;
    printf("-> 데이터를 추가하였습니다.\n");
}

// 전체 데이터 출력 함수
void printAllData(struct HashTable *table) {
    printf("전체 데이터 출력:\n");

    for (int i = 0; i < TABLE_SIZE; ++i) {
        if (table->data[i].email[0] != '\0') {
            printf("%s,%s,%d,%s,%s\n", table->data[i].firstName,
                   table->data[i].secondName, table->data[i].age,
                   table->data[i].email, table->data[i].company);
        }
    }

    printf("\n");
}

int main(int argc, char *argv[]) {
    FILE *file;
    char line[MAX_LINE_SIZE];
    char *token;

    // 명령행 인수 체크
    if (argc != 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    char *fname = argv[1];

    // 파일 열기
    file = fopen(fname, "r");
    if (file == NULL) {
        printf("파일을 열 수 없습니다.");
        return 1;
    }

    // 해시 테이블 초기화
    struct HashTable table;
    memset(&table, 0, sizeof(struct HashTable));

    // 한 줄씩 파일 읽기
    while (fgets(line, MAX_LINE_SIZE, file) != NULL) {
        struct Person person;
        // 쉼표로 구분된 데이터 파싱
        sscanf(line, "%[^,],%[^,],%d,%[^,],%s",
               person.firstName, person.secondName, &person.age,
               person.email, person.company);

        // 데이터 해시 테이블에 삽입
        insert(&table, &person);
    }

    // 파일 닫기
    fclose(file);

    // 해시 테이블 출력
    printAllData(&table);

    return 0;
}
