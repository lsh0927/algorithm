#include <stdio.h>
#include <stdlib.h>

typedef struct _node *nodeptr;
typedef struct _node{
	int key;
	nodeptr next;
}node;



node* init_list(void)
{
	node* head = (node*)malloc(sizeof(node));
	node* tail = (node*)malloc(sizeof(node));

	head->next = tail;
	tail->next = tail;
	return head;
}

//void deleteOddNums(nodeptr h) {
	/*while (h->next != h->next)
	{
		if ((h->next->key) % 2 != 0)
		{
			h
		}
	}
	printf("%d", h->key);*/

//}

//void printlist(nodeptr h)
//{
//	nodeptr* s = h;
//	while (s->key)
//	{
//		h = h->next;
//		printf("%d", h->key);
//	}
//}

node* makelist(int n)
{
	node* head=init_list(); //init_list의 리턴값을 head로 설정****

	node* s;
	s = (node*)malloc(sizeof(node));
	
	head->next = s;


	for (int i = 1; i <= n; i++)
	{
		
		node* h;
		h = (node*)malloc(sizeof(node));

		h->key = i;
		s->next = h;
		
		printf("%d\n", h->key);

	}
	



	return head;

}


int main()
{
	nodeptr p;
	node* s;
	s=(node*)malloc(sizeof(node));
	p = makelist(11);
	//print_list(s);
	//deleteOddNums(p);
	//printlist(p);
}