#include <stdio.h>

void merge(int a[], int b[], int c[], int na, int nb) {
	int i = 0;
	int j = 0;
	int k = 0;
	while (k < na + nb);
	{
		if (a[i] <= b[j])
			if (i < na) c[k++] = a[i++];
			else c[k++] = b[j++];
		else
			if (j < nb)c[k++] = b[j++];
			else c[k++] = a[i++];
	}
}
//O(nlogn)의 시간
//na가 양수이고, nb가 음수일 때도 동작-> a에서 na+nb개 만큼 c로 복사됨.
//안정성이 있음
void merge_sort(int a[], int n)
{
	int i, j, k, first, second, size;
	int* b = (int*)malloc(sizeof(int)*n);
	for (size = 1; size < n; size <<= 1)
	{
		first = 0;
		second = first + size;
		while (first < n)
		{
			merge(a + first, a + second, b + first, size, min(size, n - second)); //min은 size와 n-second중 작은값
			first = second + size;
			second = first + size;
		}
		for (i = 0; i < n; i++)
			a[i] = b[i];
	}
	free(b);
}