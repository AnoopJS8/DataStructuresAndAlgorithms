/*
ALGORITHM:

1.Add to a stack(i.e the indices) if current value is equal or bigger than the top of the stack.

2.Otherwise keep removing from the stack till a number which is smaller or empty//equal than current is found.

3.Calculate Area every time you remove as
    if(stack is empty)
        area=input[top]*i;
    else
        area=input[top]*(i-stacktop-1)

Ref:
*/
#include<iostream>
#include<stack>

using namespace std;
/*
int main()
{
    stack<int> s;
    int arr[3]={1,2,4};
    int i=0,area,max_area=-1;
    int len=sizeof(arr)/sizeof(int);
    //cout<<len;
    s.push(i);
    int top=s.top();
    if(arr[i]>=arr[top])
    {
        s.push(++i);
        top=s.top();
    }else{
        top=s.top();
        s.pop();
        i++;
        if(s.empty())
        {
            area=arr[top]*i;
        }
        else{
            area=arr[top]*(i-top-1);
        }
        if (max_area<area)
            max_area=area;
    }
    cout<<max_area;
    return 0;
}
*/
int main()
{
    //In this case what we do is to find the minimum bar height and multiply with the span to get the area.
    //int arr[3]={1,2,4};
    //int arr[7]={6,2,5,4,5,1,6}; //Ans=3*4=12
    int arr[4]={1,1,4,4};
    int i,j,area=0,max_area=0,smallest_ht=0;
    int len=sizeof(arr)/sizeof(int);
    for(i=0;i<len;i++)
    {
        //small_ht=arr[i];
        smallest_ht=arr[i];
        for(j=i;j<len;j++)
        {
            //smallest_ht=arr[i];
            if(smallest_ht>arr[j])
              {

              smallest_ht=arr[j];
                //area=arr[i]*(j+1);
              //cout<<arr[j]<<" ";
            //}else{
                //area=arr[j]*(j+1);
                //smallest_ht=arr[j];
            }
            //cout<<smallest_ht<<" ";
            area=smallest_ht*(j-i+1);
            //cout<<area<<endl;
            if(max_area<area)
                max_area=area;
        }
    }
    cout<<"Max Area=> "<<max_area;
}
