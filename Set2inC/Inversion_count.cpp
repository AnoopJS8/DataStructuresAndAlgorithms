#include<iostream>
#include<cstdio>

using namespace std;

//int main()
//{
//    int inv_count=0;
//    //int a[]={1,20,6,4,5};
//    int a[]={2,4,1,3,5};
//    int N=5;
//    for(int i=0;i<N;i++)
//    {
//        for(int j=0;j<N;j++)
//        {
//            if(a[i]>a[j] && i<j)
//                inv_count++;
//        }
//    }
//    cout<<inv_count;
//
//    return 0;
//}

int getInvCount(int arr[], int n)
{
  int inv_count = 0;
  int i, j;

  for(i = 0; i < n - 1; i++)
    for(j = i+1; j < n; j++)
      if(arr[i] > arr[j])
        inv_count++;

  return inv_count;
}

/* Driver progra to test above functions */
int main(int argv, char** args)
{
  int arr[] = {1, 20, 6, 4, 5};
  printf(" Number of inversions are %d \n", getInvCount(arr, 5));
  getchar();
  return 0;
}
