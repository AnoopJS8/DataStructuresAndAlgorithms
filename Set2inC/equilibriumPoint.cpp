#include<iostream>

using namespace std;
//
//int equilibriumPoint(int arr[],int n){
//    int sum1=0;
//    int sum2=0;
//    for(int i=1;i<n;i++)
//    {
//        sum1+=arr[i-1];
//        for(int j=i+1;j<n;j++)
//        {
//            sum2+=arr[j];
//
//        }
//        if(sum1==sum2){
//            return i;
//        }
//        sum2=0;
//    }
//    return -1;
//
//}

#include <stdio.h>

int equilibrium(int arr[], int n)
{
  int i, j;
  int leftsum, rightsum;

  /* Check for indexes one by one until an equilibrium
    index is found */
  for ( i = 0; i < n; ++i)
  {
    leftsum = 0;  // initialize left sum for current index i
    rightsum = 0; // initialize right sum for current index i

    /* get left sum */
    for ( j = 0; j < i; j++)
      leftsum  += arr[j];

    /* get right sum */
    for( j = i+1; j < n; j++)
      rightsum += arr[j];

    /* if leftsum and rightsum are same, then we are done */
    if (leftsum == rightsum)
      return i;
    }

  /* return -1 if no equilibrium index is found */
  return -1;
}

int main()
{
  int arr[] = {-7, 1, 5, 2, -4, 3, 0};
  int arr_size = sizeof(arr)/sizeof(arr[0]);
  //cout<<equilibriumPoint(arr, arr_size)<<endl;
  cout<<equilibrium(arr, arr_size)<<endl;

  //getchar();
  return 0;
}
