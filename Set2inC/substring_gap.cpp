#include<iostream>
#include<string.h>

using namespace std;

int main()
{
    string A="abcabaabcnabacmabcnabc";
    string pat="bccany";
    int lenA=A.length();
    int len_pat=pat.length();
    int i,j,k,count1=0;
    i=j=0;
    k=-1;
    bool found=false;
    while(i<lenA)
    {
        if(A[i]==pat[j])
        {

            j++;
            if(j==len_pat)
            {
                found=true;
                //break;
                //j=0;
                count1++;
            }
        }
        i++;
    }
    if(found)
        cout<<k+1<<endl<<count1<<endl;
    else
        cout<<"Not found";

}
