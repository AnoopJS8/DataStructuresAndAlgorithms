#include<stdio.h>
#include<string.h>
#define MAX 100
#define arrayLength(array) (sizeof((array))/sizeof((array)[0]))

//void merge(int L[],int R[],int A[]);
void merge(int L[],int nL,int R[],int nR,int A[]);
void mergeSort(int A[],int n);

void main()
{
int A[] = {6,2,3,1,9,10,15,13,12,17}; // creating an array of integers. 
	int i,numberOfElements;
 
	// finding number of elements in array as size of complete array in bytes divided by size of integer in bytes. 
	// This won't work if array is passed to the function because array
	// is always passed by reference through a pointer. So sizeOf function will give size of pointer and not the array.
	// Watch this video to understand this concept - http://www.youtube.com/watch?v=CpjVucvAc3g  
	numberOfElements = sizeof(A)/sizeof(A[0]); 
 
	// Calling merge sort to sort the array. 
	mergeSort(A,numberOfElements);
 
	//printing all elements in the array once its sorted.
	for(i = 0;i < numberOfElements;i++) 
	printf("%d ",A[i]);

}

void merge(int L[],int nL,int R[],int nR,int A[])
{
//int nL=arrayLength(L);
//int nR=arrayLength(R);
int i,j,k;
i=j=k=0;
while(i<nL && j<nR)
{
if(L[i]<R[j]){
A[k++]=L[i];
i=i++;
}else
{
A[k++]=R[j++];

}
}
while(L[i])
A[k++]=L[i++];

while(R[j])
A[k++]=R[j++];


}

void mergeSort(int A[],int n){
if(n<2)
 return;
int i,j,mid;
n=arrayLength(A);

mid=n/2;
int ln=mid;
int rn=n-(mid+1);
int L[ln],R[rn];
int nL=arrayLength(L);
int nR=arrayLength(R);
for(i = 0;i<mid;i++)
 L[i] = A[i]; // creating left subarray
for(i = mid;i<n;i++)
 R[i-mid] = A[i]; // creating right subarray
mergeSort(L,mid);  // sorting the left subarray
mergeSort(R,n-mid);  // sorting the right subarray
merge(L,ln,R,rn,A);  // Merging
}
