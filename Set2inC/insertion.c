#include<stdio.h>

int main()
{

int A[]={1,5,4,2,6,3};

int i,j,key;

for(i=0;i<sizeof(A)/sizeof(int);i++)
	printf("%d",A[i]);printf("\n");

for(j=2;j<sizeof(A)/sizeof(int);j++){
	key=A[j];
	for(i=j-1;i<j;i--){
		if(A[i]>key)
			A[i+1]=A[i];
		else
			break;
}	A[i+1]=key;
}
printf("Insertion sorted\n");
for(i=0;i<sizeof(A)/sizeof(int);i++)
	printf("%d",A[i]);

return 0;
}
