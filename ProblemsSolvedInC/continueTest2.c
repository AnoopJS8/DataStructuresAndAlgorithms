#include <stdio.h>
 
int main ()
{
int a;
int product=1;
do
{
printf("Enter the number \n");
scanf("%d",&a);
if(a==0)
{
	continue;
}
product*=a;
}while(a<4);
printf("product is \t %d \n",product);
}
