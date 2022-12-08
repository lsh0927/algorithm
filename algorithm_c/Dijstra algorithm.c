#include <stdio.h>
#define V 7
#define MAX 1000
void printSolution(int dist[][V]);

void allcosts(int cost[][V],
    int distance[][V], int n) {
    /* 각 정점에서 다른 모든 정점으로의 거리 계산,cost:인접 행렬, distance:거리값*/
    int i, j, k;
    for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
            distance[i][j] = cost[i][j];
    for (k = 0; k < V; k++)
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                if (distance[i][k] + distance[k][j] < distance[i][j]) {
                    distance[i][j] = distance[i][k] + distance[k][j];
                    printf(" %d - % d - % d: % d\n", i, k, j, distance[i][j]);

                }
}
void main(void)
{
    int cost[7][7] = { {0,7,9,3,MAX,MAX,MAX},{MAX,0,1,MAX,6,9,MAX}, {MAX,MAX,0,MAX,MAX,MAX,MAX},
    {MAX,2,MAX,0,MAX,MAX,MAX},{MAX,MAX,MAX,MAX,0,2,1},{MAX,MAX,1,MAX,MAX,0,MAX},{9,MAX,MAX,MAX,MAX,MAX,0} };
    int distance[7][7];

    allcosts(cost, distance, V);
    
    printSolution(distance);
}
void printSolution(int dist[][V])
{
    printf("\t   to→ "); //dist 수치를 보기 쉽게 정리

    for (int i = 0; i < V; i++)
        printf("[%d]    ", i);

    printf("\n      ↓from \n"); //dist수치를 보기 쉽게 정리

    for (int i = 0; i < V; i++)
    {
        printf("\t[%d]", i);
        for (int j = 0; j < V; j++)
        {
            if (dist[i][j] == MAX)
                printf("%7s", "MAX");
            else
                printf("%7d", dist[i][j]);
        }
        printf("\n");
    }
}