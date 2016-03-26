#include<iostream>
using namespace std;

template <class T>
void bubble(T *items,int count){
    register int i,j;
    T t;

    for(i=0;i<count-1;i++){
        for(j=0;j<count-1;j++){
            if(items[j]>items[j+1])
            {
                t=items[j];
                items[j]=items[j+1];
                items[j+1]=t;

            }
        }
    }

}

int main(){

   // int i;
    int iarray[]={7,5,4,3,9,8,6};
    double darray[]={2.3,4.5,6.7,1.2};
    bubble(iarray,7);
    bubble(darray,4);
    for (int i=0;i<7;i++)
        cout<<iarray[i]<<" ";
    cout<<endl;
    cout<<endl;
    for (int i=0;i<4;i++)
        cout<<darray[i]<<" ";
    cout<<endl;
}
