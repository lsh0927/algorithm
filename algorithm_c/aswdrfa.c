#include <stdio.h>
#include <stdlib.h>
#define MAX 100 

typedef struct _node* nodeptr;
typedef struct _node {
    int val;
    nodeptr next;
} node;

typedef struct {
    nodeptr head;
    nodeptr tail;
    nodeptr rear;
    int count;
} queue;

queue* create_queue() {
    queue* q = (queue*)malloc(sizeof(queue));
    q->head = (node*)malloc(sizeof(node));
    q->tail = (node*)malloc(sizeof(node));
    q->rear = q->head;
    q->head->next = q->tail;
    q->count = 0;
    return q;
}

void clear_queue(queue* q) {
    q->head = q->tail;
}

int put(queue* q, int k)
{
    nodeptr p;
    p = malloc(sizeof(node));
    if (q->count == MAX)
    {
        printf("\n queue is overflow");
        return -1;
    }

    q->rear->next = p;
    p->val=k;
    p->next = q->tail;
    q->rear = p;
    q->count = q->count + 1;
    return k;
}
int get(queue* q) {
    int i;
    if (q->head == q->tail)
    {
        printf("\n queue is empty");
        return -1;
    }
    i = q->head->next->val;
    q->head = q->head->next;
    return i;
}
void print_queue(queue* q) {
    node* p;
    printf("\n Queue contents : Front ----> Rear\n");
    for (p = q->head->next; p != q->tail; p = p->next)
        printf("%-6d", p->val);
}
int main(void) {
    int i;
    queue* q = create_queue();
    printf("\nPut 5, 4, 7, 8, 2, 1");
    put(q, 5); put(q, 4); put(q, 7);
    put(q, 8); put(q, 2); put(q, 1);
    print_queue(q);
    printf("\nGet"); i = get(q);
    print_queue(q);
    printf("\n   getting value is %d", i);
    printf("\nPut3, 2, 5, 7");
    put(q, 3); put(q, 2); put(q, 5); put(q, 7);
    print_queue(q);
    printf("\nNowqueue if full, put 3");
    put(q, 3);
    print_queue(q);
    printf("\nInitializequeue");
    clear_queue(q);
    print_queue(q);
    printf("\nNowqueue is empty, get");
    i = get(q);
    print_queue(q);
    printf("\n   getting value is %d\n", i);
}