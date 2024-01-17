#include <stdio.h>



int foo1(int a[], int n){
    int i,j;
    int s=0;
    for(i=1;i<=n;i++){
        for(j=0;j<i;j++){
            s+=a[j];
        }
    }
    return s;
}
int main(){
    int x[1000];
    int i,r;
    printf("이현우\n");

    for(i=0;i<1000;i++){
        x[i]=i;
    }

    r=foo1(x,1000);
}