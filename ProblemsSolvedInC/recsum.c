#include<stdio.h>
int sum=0;
int main()
{
int n;
printf("Enter the number until the sum is required \n");
scanf("%d",&n);
int sum=recsum(n);
printf("Result= %d",sum);

return 0;
}

int recsum(int n)
{
if(n>0)
{
recsum(n-1);
sum=sum+n;
}
return sum;
}
