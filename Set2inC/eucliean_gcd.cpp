#include<iostream>
using namespace std;
/*
void swap(int *t1,int *t2)
{
    int t;
    t=*t1;
    *t1=*t2;
    *t2=t;
}
int gcd1=1;
int gcd(int numb1,int numb2)
{
    if(numb2>numb1)
        swap(&numb1,&numb2);

    int q,r,gcd1;
    q=numb1/numb2;
    r=numb1%numb2;
    //gcd1=gcd(q,r);
    if(r==0)
        return q;

    gcd1=gcd(q,r);

}*/
int gcd(int a, int b) {
  if (b == 0)
    return a;

  return gcd(b, a % b);
}
int main()
{
    cout<<gcd(3768,1701);


}
/*
    gcd(10,45)
    45=10.4+5
    10=5.2+0

*/
