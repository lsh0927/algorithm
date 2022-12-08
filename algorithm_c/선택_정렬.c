#include <stdio.h>
#include<stdlib.h>

//void select_sort(int a[], int n)
//{
//   char min;
//   int minindex;
//   int i, j;
//
//   for (i = 0; i < n - 1; i++)
//   {
//      minindex = i;
//      for (j = i + 1; j < n; j++)
//      {
//         if (a[minindex] > a[j])
//            minindex = j;
//
//         min = a[minindex];
//         a[minindex] = a[i];
//         a[i] = min;
//
//      }
//   }
// }

void select(int a[], int n)
{
   int min, minindex;
   if (n <= 1) return -1;
   minindex = find_min(a, n);
   min = a[minindex];
   a[minindex] = a[0];
   a[0] = min;
   select(a + 1, n - 1);
}
int find_min(int a[], int n)
{
   int minindex, j;
   minindex = 0;
   for (j = 1; j < n; j++)
   {
      if (a[minindex] > a[j]) minindex = j;
   }
   return minindex;

} 

int main()
{
   int a[] = { 5,1,9,3,8 };
   select(a, 5);
   for (int i = 0; i < 5; i++)
   {
      printf("%d\n", a[i]);
   }
}