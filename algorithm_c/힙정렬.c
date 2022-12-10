#include <stdio.h>
#define INT_MAX 1000
//힙정렬

//우선순위 큐의 일종인 힙을 사용
//각각의 노드의 값이 그 자식 노드들의 값보다 크거나 같은 성질을 갖는 이진 완전 트리
//루트 노드가 가장 큰 값을 가지고 있다
//힙을 만들고 루트 노드에서 하나씩 꺼내서 배열의 끝에 저장한다.

/*sort n elements: a[1]....a[n]*/

void t_heap_sort(int a[], int n)
{
	int i;
	printf("\n Heap sort");
	for (i = 2; i <= n; i++) //i=1일때는 어차피 heap임
		upheap(a, i);
	for (i = n; i > 1; i--)
	{
		int v = a[1];
		a[1] = a[i];
		a[i] = v;
		downheap(a, i - 1, 1);
	}
}
void upheap(int a[], int k)
{
	int v;
	v = a[k];
	a[0] = INT_MAX;
	while (a[k / 2] <= v) { //계속 부모 노드랑 비교, 자식이 더 크다면 부모 노드와 위치를 바꿈
		a[k] = a[k / 2];
		k /= 2;
	}
	a[k] = v;
}
void downheap(int a[], int n, int k)
{
	int i, v;
	v = a[k];
	while (k <= n / 2) {//k가 leaf일때까지 
		i = k << 1;
		if (i < n && a[i] < a[i + 1]) i++; //i<n, 오른쪽 노드가 더 클 경우 i++
		if (v >= a[i]) break;  //자식을 부모로 올림.
		a[k] = a[i]; //a[k]에 a[i]를 넣음
		k = i;
	}
	a[k] = v;
}