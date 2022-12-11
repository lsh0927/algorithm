#include<stdio.h>

int f(int x) { return x * x; }
int f2(int x) { return x + 3; }
int f3(int x) { return x * 7; }
int f4(int (*f)(int), int i) { return f(f(i)) + 1; }

int f5(int (*h)(int), int (*g)(int)) { return g(h(4)); }
int main()
{
	typedef int (*IntToIntFun)(int);
	IntToIntFun g;
	printf("%d\n", f4(f, 2));
	printf("%d\n", f5(f2, f3));
	g = f2;
	printf("%d\n", f4(g, 3));
	return 0;
}
