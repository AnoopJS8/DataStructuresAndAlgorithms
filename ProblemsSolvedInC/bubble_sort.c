#include<stdio.h>
#include<stdlib.h>
int main()
{
int i,n,temp=0,*ptr;
printf("Enter the no of numbers you want to sort\n");
scanf("%d",&n);
ptr=(int*)malloc(n*sizeof(int));

if(ptr==NULL)
	{
		fprintf(stderr,"Not enough memory.");//it writes the error onto the screen output.
		exit(0);
	}
printf("Enter the numbers you want to sort\n");

for(i=0;i<n;i++)
{
scanf("%d",ptr+i);
//printf("%d",*(ptr+i));	
//ptr=(int *)malloc(sizeof(int));
	/*if(ptr==NULL)
	{
		fprintf(stderr,"Not enough memory.");
		exit(0);
	}*/
	

}
//Bubble_Sort
//ptr=arr;
for(i=0;i<n-1;i++)
{
for(int j=0;j<n-1-i;j++)
{
	if(*(ptr+j)>*(ptr+j+1)){
	temp=*(ptr+j);
	*(ptr+j)=*(ptr+j+1);
	*(ptr+j+1)=temp;
}
}

}
printf("The sorted Array");
for(i=0;i<n;i++)
{
printf("%d",*(ptr+i));
}

free(ptr);
return 0;
}


