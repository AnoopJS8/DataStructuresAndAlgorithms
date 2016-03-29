/*
ALGORITHM:
-If we include bar i, maximum possible height of rectangle including that bar will be h(i), height of that bar.
-If we include bar i, maximum possible width of rectangle including that bar will be L+R+1, where:
-L is number of adjacent bars to the left of ith bar and height greater than or equal to h(i).
-R is number of adjacent bars to the right of ith bar and height greater than or equal to h(i).

----------------------TASK--TO-BE--DONE--------------------
1) Get Li
2) Get Ri
3) Get area of rectangle for bar i: A(i) = h(i) * (Li+Ri+1)
4) Find max value of A(i)

--------------------------------+--------------------------------------------------------
If we include bar i, maximum possible width of rectangle including that bar will be L+R+1, (we include 1 for that ith bar)where:
L is number of adjacent bars to the left of ith bar and height greater than or equal to h(i).
R is number of adjacent bars to the right of ith bar and height greater than or equal to h(i).

Finally Li = (i – TOP-of-stack).
Ref:http://tech-queries.blogspot.in/2011/03/maximum-area-rectangle-in-histogram.html
*/
#include<iostream>
#include<stack>

using namespace std;

//Here input is an input[len] array which contains the heights of the bars
int largestArea(int arr[],int len)
{
    int area[len];
    int Li[len];// No of adjacent leftBars to the ith bar and height greater than input[i].
    int Ri[len];
    int n,i,top;
    stack<int> Stack;

    for(i=0;i<len;i++)
    {
        while(!Stack.empty())
        {
            if(arr[i]<=arr[Stack.top()])
            {
                Stack.pop();
            }
            else
                break;
        }
        if(Stack.empty())
        {
            top=-1;
        }else{
            top=Stack.top();
        }

        //Calculate Li
        Li[i]=i-top-1;
        Stack.push(i);

    }

    //Now Clear the Stack to find Ri
    while(!Stack.empty())
        Stack.pop();

    //To calculate Ri we start Backwards
    for(i=len-1;i>=0;i--)
    {
        while(!Stack.empty())
        {
            if(arr[i]<=arr[Stack.top()])
            {
                    Stack.pop();
            }else
            {
                break;
            }



        }

        if(Stack.empty())
        {
            top=len;
        }
        else{
            top=Stack.top();
        }

        Ri[i]=top-i-1;
        Stack.push(i);

    }
    int max = 0;
//Calculating Area[i] and find max Area
for (i=0; i<len; i++)
{
    area[i] = arr[i] * (Li[i] + Ri[i]+ 1);
        if (area[i] > max)
            max = area[i];
    }

    return max;
}



int main(){
    int arr[4]={1,1,4,4};
    int len=4;
    cout<<largestArea(arr,len);
    return 0;
}
