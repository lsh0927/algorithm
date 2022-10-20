#include <stdio.h>
#define MAX 46
int fibos[MAX] = { 0 };
int fibo(int n) {
	int fib;

	if (n == 1 || n == 2)
		fib = 1;
	else if (fibos[n] != 0)
		return fibos[n];
	else
	{
		fib = fibo(n - 1) + fibo(n - 2);
		fibos[n] = fib;
	}
	return fib;
}

int main()
{
	int n;
	scanf("%d", &n);
	if (n < 1)
	{
		printf("Number must be positive"); return 0;

	}
	printf("%d the fibo is %u\n", n, fibo(n));
}