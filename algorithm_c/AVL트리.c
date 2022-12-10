//AVL 트리

//모든 노드에 대하여 오른쪽 나무와 왼쪽 나무의 높이의 차가 1이하인 이진나무

//삽입 알고리즘은 이진검색나무와 같으나, 균형도 조정 필요시 회전!

//L회전 

typedef struct _node {
	int key;
	struct _node* left;
	struct _node* right;
} node;


node* l_rotate(node* p) {
	node* s;
	s = p->left;
	p->left = s->right;
	s->right = p;
	return s;
}
node* r_rotate(node* p) {
	node* s;
	s = p->right;
	p->right = s->left;
	s->left = p;
	return s;
}