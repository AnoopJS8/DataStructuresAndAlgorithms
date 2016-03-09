#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void maxSubArrayNC(int *A,int len)
{
    int currentSum=0;
    int currentIndex=-1;
    int maxSum=0;
    int maxStartIndex=-1;
    int maxEndIndex=-1;
    int val=0;
    for(int i=0;i<len;i++)
        {
       if(A[i]>=0)
           maxSum+=A[i];
       else
         val++;
    }
    if(val==len)
        cout<<A[0]<<" ";
    else
        cout<<maxSum<<" ";
    
    
    
}

void maxSubArray(int *A,int len)
{
    int currentSum=0;
    int currentIndex=-1;
    int maxSum=0;
    int maxStartIndex=-1;
    int maxEndIndex=-1;
    int val=0,count=0;
    for(int i=0;i<len;i++)
        {
        val=currentSum+A[i];
        if(val>0)
            {
            if(currentSum==0)
                {
                currentIndex=i;
            }
            currentSum=val;
        }else{
            currentSum=0;
            count++;
        }
        
        if(currentSum>maxSum)
            {
            maxSum=currentSum;
            maxStartIndex=currentIndex;
            maxEndIndex=i;
        }
        
    }
    
   // cout<<maxSum<<" ";
    if(count==len)
        cout<<A[0]<<" ";
    else
        cout<<maxSum<<" ";
    
    
    
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int T,*arr;
    cin>>T;
    int N;
    while(T--)
        {
        cin>>N;
        arr=new int[N];
        for(int j=0;j<N;j++)
            cin>>arr[j];
        maxSubArray(arr,N);
        maxSubArrayNC(arr,N);
        cout<<endl;
       free(arr);
    }
    
    
    return 0;
}