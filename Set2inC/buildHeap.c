#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define HeapSize 8
//#define left(i) i<<1;
//#define right(i) (i<<1) +1;
int parent(int);
int left(int);
int right(int);
void MaxHeapify(int A[],int i);
void BuildHeap(int []);
int main(){
	int A[]={5,3,17,10,84,19,6,22,9};
	int i;
	printf("Before Max-Heapifying :\n");
	for(i=0;i<sizeof(A)/sizeof(int);i++)
		printf("%d",A[i]);
	printf("\n");
	//MaxHeapify(A,1);
	BuildHeap(A);
	printf("After Max-Heapifying :\n");
	for(i=0;i<sizeof(A)/sizeof(int);i++)
		printf("%d",A[i]);
	printf("\n");
	return 0;
}

int parent(int i){
	return (floor(i/2));
}

int left(int i){
	//return 1;
	//printf("inside left");
	/*if(i == 0) 
		return 1;
	else 
		return 2*i; //i<<1;*/
	return 2*i+1;
}

int right(int i){
	/*if(i == 0) return 2;
	else 
	return (2*i+1); */
	return 2*i+2;
}

void MaxHeapify(int A[],int i){
	int l,r,temp,max;	
	l=left(i);
	r=right(i);
	if(l<=HeapSize && A[i]<A[l])
		max=l;
	else
		max=i;
	if(r<=HeapSize && A[max]<A[r])
		max=r;	
	//else 
	//	max=i;
	if(max!=i){
		temp=A[i];
		A[i]=A[max];
		A[max]=temp;
//	}
	
	MaxHeapify(A,max);
	}	
}

void BuildHeap(int A[]){
	int i;
	for(i=floor(HeapSize/2);i>=0;i--){
	MaxHeapify(A,i);
}
}
