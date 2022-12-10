#include <stdio.h>
#define MAX 100
int index = 0;
int array[MAX];

typedef struct _node {
	int key;
	struct _node* left;
	struct _node* right;
} node;


void init_tree(node** p) {
	*p = (node*)malloc(sizeof(node));
	(*p)->left = NULL;
	(*p)->right = NULL;
}

node* bti_search(int key, node* base, int* num) {
	node* s;
	s = base->left; /* base 포인터의 left child가 루트 노드 */
	while (s != NULL && key != s->key)
		/* tail 노드를 사용하지 않음. NULL 포인터로 대체 */
		if (key < s->key)
			s = s->left;
		else s = s->right;
	return s;
}
node* bti_insert(int key, node* base, int* num) {
	node* p, * s;
	p = base;
	s = base->left;
	while (s != NULL) {
		p = s;
		if (key < s->key) s = s->left;
		else s = s->right;
	}
	if ((s = (node*)malloc(sizeof(node))) == NULL)
		return NULL;
	s->key = key;
	s->left = NULL;
	s->right = NULL;
	if (key < p->key || p == base) p->left = s;
	else
		p->right = s;
	(*num)++;
	return s;
}
node* bti_delete1(int key, node* base, int* num) {
	node* parent, * son, * del, * nexth;
	parent = base;
	del = base->left;
	while (del != NULL && key != del->key) {
		parent = del;
		if (key < del->key) del = del->left;
		else del = del->right;
	}
	if (del == NULL) return NULL;
	if (del->left == NULL && del->right == NULL)
		son = NULL;
	else if (del->left == NULL || del->right == NULL)
	{
		if (del->left != NULL) son = del->left;
		else son = del->right;
	}
	else {
		nexth = del->right;
		if (nexth->left == NULL) {
			son = nexth;
			son->left = del->left;
		}
		else {
			while (nexth->left->left != NULL)
				nexth = nexth->left;
			son = nexth->left;
			nexth->left = son->right;
			son->left = del->left;
			son->right = del->right;
		}
	}
	if (key < parent
		->key || parent == base)
		parent
		->left = son;
	else parent->right = son;
	free(del);
	(*num)--
		;
	return parent;
}
node* bti_delete(int key, node* base, int* num) {
	node* parent, * son, * del, * nexth;
	parent = base;
	del = base->left;
	while (key != del->key && del != NULL) {
		parent = del;
		if (key < del->key) del = del->left;
		else del = del->right;
	}
	if (del == NULL) return NULL;
	if (del->right == NULL)
		son = del->left;
	else if (del->right->left == NULL) {
		son = del->right;
		son->left = del->left;
	}
	else {
		nexth = del->right;
		while (nexth->left->left != NULL)
			nexth = nexth->left;
		son = nexth->left;
		nexth->left = son->right;
		son->left = del->left;
		son->right = del->right;
	}
	if (key < parent->key || parent == base)
		parent->left = son;
	else
		parent->right = son;
	free(del);
	(*num)--;
	return parent;
}
void bti_sort(node* p) //노드를 중위 순회하면서 배열에 키값을 저장->크기순으로 정렬 가능
{
	if (p != NULL)
	{
		bti_sort(p->left);
		array[index++] = p->key;
		bti_sort(p->right);
	}
}
