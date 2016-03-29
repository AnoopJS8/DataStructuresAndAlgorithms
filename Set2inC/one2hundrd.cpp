#include <csetjmp>
#include <iostream>
using namespace std;
int main()
{
    jmp_buf b;
    int x = 1;
    setjmp(b);
    cout << x++ << endl;
    if (x <= 100)
        longjmp(b, 0);
    return 0;
}
