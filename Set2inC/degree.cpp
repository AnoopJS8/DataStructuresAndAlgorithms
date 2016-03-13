#include<iostream>

using namespace std;

//int main()
//{
//    int i,j,k,degree=2;
//    for(i=2;i>=0;i--)
//    {
//        for(j=0;j<=i;j++)
//        {
//            for(k=0;k<=j;k++)
//            {
//                cout<<(i-j-k)<<"."<<j<<"."<<k<<"    ";
//            }
//        }
//    }
//    return 0;
//}

int main()
{
    int i,j,k,degree=2;
    for(i=2;i>=0;i--)
    {
        for(j=0;j<=i;j++)
        {
                cout<<(i-j)<<"."<<j<<"."<<"    ";

        }
    }
    return 0;
}
