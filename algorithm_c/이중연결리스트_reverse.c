#include <stdio.h>
#include <memory.h>
#include <stdlib.h>

typedef struct _dnode
{
    int key;
    struct _dnode* prev;
    struct _dnode* next;
} dnode;

dnode* head, * tail;

void init_dlist(void)
{
    head = (dnode*)malloc(sizeof(dnode));
    tail = (dnode*)malloc(sizeof(dnode));
    head->next = tail;
    head->prev = head;
    tail->next = tail;
    tail->prev = head;
}

dnode* insert_dnode_ptr(int k, dnode* t)  /* insert k, before t */
{
    dnode* i;
    if (t == head)
        return NULL;
    i = (dnode*)malloc(sizeof(dnode));
    i->key = k;
    t->prev->next = i;
    i->prev = t->prev;
    t->prev = i;
    i->next = t;
    return i;
}


void reverse_list(dnode* p)
{
    while (p != head)
    {
        insert_dnode_ptr(p->key, tail);
        p = p->prev;
    }
    printf("\n");
}

void print_dlist(dnode* p)
{
    while (p != tail)
    {
        printf("%d ", p->key);
        p = p->next;
    }
    printf("\n");
}



void main(void)
{
    int i;
    init_dlist();

    for (i = 1; i <= 10; i++) {
        insert_dnode_ptr(i, tail);

    }
    printf("리스트 생성 완료!");
    
    reverse_list(tail->prev);
    print_dlist(head->next);
}
