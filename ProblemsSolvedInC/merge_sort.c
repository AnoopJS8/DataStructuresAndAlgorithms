#include<stdio.h>
#include<math.h>

#define INF 10000

void merge(int A[], int low, int mid, int high);
void mergesort(int A[], int low, int high);

/*void merge(int a[], int low, int mid, int high)
{
/*int n1=mid-low+1;
int n2=high-mid;
int L[n1],R[n2],i,j,k;
for(i=0;i<=n1;i++){
	L[i]=A[low+i];/* printf("\n%d\n",L[i]);}*/
/*
for(j=0;j<=n2;j++){
	R[j]=A[mid+j+1]; /*printf("\n%d\n",R[i]);}
L[n1+1]=INF;
R[n2+1]=INF;
 i=0,j=0;
for(k=low;k<high;k++){
if(L[i]<R[j])
	{A[k]=L[i];j+=1;}
else{
    	A[k]=R[j];j+=1;
}
}*/
void merge(int a[], int low, int mid, int high)
{
int b[10000];
    int i =low, j =mid + 1, k = 0;
  
    while (i <= mid && j <= high) {
        if (a[i] <= a[j])
            b[k++] = a[i++];
        else
            b[k++] = a[j++];
    }
    while (i <= mid)
        b[k++] = a[i++];
  
    while (j <= high)
        b[k++] = a[j++];
  
    k--;
    while (k >= 0) {
        a[low + k] = b[k];
        k--;
    }

}

void mergesort(int A[], int low, int high){

int mid;
if(low<high){
	mid=(low+high)/2;
	mid=(int)floor(mid);
	mergesort(A,low,mid);
	mergesort(A,mid+1,high);
	merge(A,low,mid,high);
}
}
int main()
{
int A[] = {15,3,2,4,5,6,67,45,3}; // creating an array of integers. 
	int i,numberOfElements;
numberOfElements = sizeof(A)/sizeof(A[0]); 
mergesort(A,0,numberOfElements-1);

	for(i=0;i < numberOfElements;i++) 
	           printf("%d ", A[i]);
return 0;
}

