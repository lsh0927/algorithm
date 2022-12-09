#include <stdio.h>

//삽입 정렬
//O(n^2), 거의 정렬된 행렬의 경우 성능이 매우 우수, 완전 정렬인 경우 n-1번의 비교
//역순일때 최악, 난수일때 선택정렬보다 좋음-> 비교는 적으나 복사는 많아서, 큰레코드에는 x
void insert_sort(int a[], int n)
{
	int i, j, t;
	for (i = 1; i < n; i++)
	{
		t = a[i];
		j = i;

		while (a[j - 1] > t&& j > 0)
		{
			a[j] = a[j - 1];
			j--;
		}

		a[j] = t;
	}
}

void insert_sort2(int a[], int n) //향상된 삽입 정렬
{
	int i, t, j;
	//제일 작은 원소를 a[0]으로 이동: O(n)-> a[0]에 보초(최소값)을 사용하면, 경계 비교가 팔요x
	for (i = 2; i < n; i++) {
		t = a[i];
		j = i;
		while (a[j - 1] > t)
		{
			a[j] = a[j - 1];
			j--;
		}
		a[j] = t;
	}
}