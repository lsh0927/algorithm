#include <stdio.h>

//퀵 정렬 ->기수교환 정렬과 유사
//축값을 중심으로 축값보다 작은 원소, 큰원소가 각각 축의 왼쪽 오른쪽에 위치하도록 함
//분할된 두개의 부분 배열에 대하여 재귀적으로 같은 작업을 반복함
//배열의 원소의 갯수가 1이 되면 작업 종료

//퀵소트(a,mid)와 퀵소트(a+mid+1,N-mid-1)을 재귀적으로 수행

int split(int a[], int n)
{
	int v, t, i, j;
	v = a[n - 1];
	i = -1;
	j = n - 1;
	while (1) {
		while (a[++i] < v);
		while (a[--j] > v&& j > i);
		if (i >= j) break;
		t = a[i]; a[i] = a[j]; a[j] = t;

	}
	t = a[i]; a[i] = a[n - 1]; a[n - 1] = t;
	return i;
}
void quick_sort(int a[], int n)
{
	int i;
	if (n > 1)
	{
		i = split(a, n);
		quick_sort(a, i);
		quick_sort(a + i + 1, n - i - 1);
	}
}
//키값이 골고루 분산된 경우 성능이 우수->이미 정렬된 경우 성능 낮음
//재귀 호출로 인한 부담이 발생(시스템 스택공간(worst case O(n))과 수행시간 소요