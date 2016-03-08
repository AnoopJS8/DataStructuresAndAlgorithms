#include <stdio.h>
#include <stdlib.h>
int main(){
    int n,i,*ptr,sum=0,temp=0,j;
    printf("Enter number of elements: ");
    scanf("%d",&n);
    ptr=(int*)malloc(n*sizeof(int));  //memory allocated using malloc
    if(ptr==NULL)                     
    {
        printf("Error! memory not allocated.");
        exit(0);
    }
    printf("Enter elements of array: ");
    for(i=0;i<n;++i)
    {
        scanf("%d",ptr+i);
        sum+=*(ptr+i);
    }
    printf("Sum=%d",sum);
/*
for(i=0;i<n-1;n++)
{
for(j=0;j<n-1-i;j++)
{
	temp=*(ptr+j);
	*(ptr+j)=*(ptr+(j+1));
	*(ptr+(j+1))=*(ptr+j);
}
}
printf("The sorted Array\n");
for(i=0;i<n;i++)
{
printf("%d\t",*(ptr+i));
}
*/
    free(ptr);
    return 0;
}

