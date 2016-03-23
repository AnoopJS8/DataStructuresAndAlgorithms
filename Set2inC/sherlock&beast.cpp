#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

   int t,flag;
   long long x,y,n,i;
   scanf("%d",&t);
     while(t--){
         x=y=0;
         flag=0;
        scanf("%lld",&n);
        if(n==1||n==2||n==4||n==7)
        {}
        else
        for(x=n,y=0;;x--,y++)
           if(x%3==0&&y%5==0)
               {flag=1;break;}
       if(flag==1){
         for(i=0;i<x;i++)
            printf("5");
         for(i=0;i<y;i++)
             printf("3");}
         else
             printf("-1");
         printf("\n");}
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    return 0;

}
