#include<stdio.h>

int main(){
    int a, b, c;

    scanf("%d", &a);
    scanf("%d", &b);
    c=b;

    int i = 0;
    while (b / a > 0){
        b = b / a;
        ++i;
    }

    printf("log%d(%d) = %d\n", a, c, i);
}