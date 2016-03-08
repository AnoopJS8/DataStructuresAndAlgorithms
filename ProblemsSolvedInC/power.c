#include<stdio.h>
int main()
{
int base,index;
long long int power=1;
printf("Enter the base \n");
scanf("%d",&base);
printf("Enter the index \n");
scanf("%d",&index);
while(index!=0)
{
power*=base;
index--;
}
printf("\n Power = %lld\n",power);

return  0;

}
