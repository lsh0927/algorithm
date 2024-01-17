#include <stdio.h>
void foo(int p[][3]){
    printf("%d\n",p[2][2]);
}
int main(){
    int a[4][5];
    int i,j;
    int *b;
    printf("%u\n",a);
    printf("%u\n",sizeof(int));
    printf("%u\n", a+2);
    printf("%u\n", (*(a+3))+2);
    for(i=0; i<4; i++)
        for(j=0; j<5; j++){
            a[i][j]=i*10+j;
            if(i==j) printf("%d",a[i][j]);
        }
    b = *(a+1);
    printf("\n%d %d\n", *b,*(b+7));
    foo(a);
}