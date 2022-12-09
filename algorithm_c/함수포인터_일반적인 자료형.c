#include <stdio.h>

일반적인 자료형에 대한 정렬 함수 만들기

함수타입: void select_sort(void *base, size_t nelem, size_t width, int(*fcmp)(const void*, const void *))

int min;  -- > void* min = malloc(width);
a[i] -- > ((char*)base + i * width)
min > a[j]->fcmp(min, (char*)base + j * width)0
a[i] = min-- > memcpy((char*)base + i * width, min, width)

함수 포인터
int addThree(int x) { return x + 3; }
int addFour(int x) { return x + 4; }
int twice(int (*f)(int), int a) { return f(f(a)); }
int main() {
	typedef int (*IntToIntFun)(int); // 함수 포인터 타입 선언
	IntToIntFun g = addThree; // int *g (int)와 같다!
	printf(" % d\n", g(4));
	printf(" % d\n", twice(addThree, 5));
	g = addFour;
	printf(" % d\n", twice(g, 5));
	return 0;
}