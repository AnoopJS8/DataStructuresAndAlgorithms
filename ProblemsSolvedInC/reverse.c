#include<stdio.h>
int main(){

int i,rev=0,n;
printf("Enter the number\n");
scanf("%d",&i);
while(i!=0)
{
n=i%10;
rev=rev*10+n;
i/=10;

}
printf("Reverse of the number is : %d \n",rev);

return 0;

}


