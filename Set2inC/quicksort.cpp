#include<iostream>
#include<stdio.h>

int partitionf(int *A,int start,int end);
void quicksort(int *A,int start,int end);
static int count=0;
//inline
void swap(int &a,int &b){
    //printf("%d\n",++count);
  //  printf( "%d %d\n",a,b);
    int t;
    t=a;
    a=b;
    b=t;
  //  printf("%d %d\n",a,b);
}

int main(){

    //int Arr[]={1,4,6,2,3,4,3,8,9};
   int Arr[]={7,2,4,3,8,8,9,10,14};
   // static int count=0;
    int len=sizeof(Arr)/sizeof(int);
    printf("Before Sorting\n");//std::cout<<len<<"#";
    for(int i=0;i<len;i++)
    {
        printf("%d ",Arr[i]);
    }
    printf("\n");
    quicksort(Arr,0,len-1);

    printf("After Sorting\n");
    for(int i=0;i<len;i++)
    {
        printf("%d ",Arr[i]);
    }
    printf("\n");

    return 0;
}

void quicksort(int *A,int start,int end)
{
   // std::cout<<end<<"!";
    if(start>=end)
        return;
    //int pivot=A[end];
    int pIndex;
    pIndex=partitionf(A,start,end);
    quicksort(A,start,pIndex-1);
    quicksort(A,pIndex+1,end);

}

int partitionf(int *A,int start,int end){

    int pivot=A[end];
  ///  std::cout<<pivot<<"@@"<<" ";
    int pIndex=start;
    for(int i=start;i<end;i++){  //while checking we have to go until the pivot should not include the pivot index
        if(A[i]<=pivot){
            swap(A[i],A[pIndex]);
            pIndex+=1;
        }

    }
    swap(A[pIndex],A[end]);

    return pIndex;

}
