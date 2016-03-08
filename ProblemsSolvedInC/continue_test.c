#include <stdio.h>
 
int main ()
{
   /* local variable definition */
   int a = 10;

   /* do loop execution */
   while(a<20)
   {
      if( a == 15)
      {
         /* skip the iteration */
         a = a + 1;
         continue;
      }
      printf("value of a: %d\n",a++);
      //a++;
     
   }
 
   return 0;
}
