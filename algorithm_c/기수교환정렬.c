#include <stdio.h>

//기수 교환 정렬 함수
//퀵 소트와 비슷함
//2진수 키값에 대하여 왼쪽 비트부터 분할하며 정렬

unsigned bits(unsigned x, int k, int j)
{
	return (x >> k) & ~(~0 << j);
}

void radix_exchange_sort(int a[], int n, int b)
{
	int t, i, j;
	if (n > 1 && b >= 0)
	{
		i = 0;
		j = n - 1;
		while (i != j)
		{
			while (bits(a[i], b, 1) == 0 && i < j) i++;
			while (bits(a[j], b, 1) != 0 && i < j)j--;
			t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		if (bits(a[n - 1], b, 1) == 0) j++; //아마 모든 비트가 0일때 j를 증가하는거 같은데 왜?
		radix_exchange_sort(a, j, b - 1);
		radix_exchange_sort(a + j, n - j, b - 1);
	}
}