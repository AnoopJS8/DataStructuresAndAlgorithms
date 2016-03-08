#include <stdio.h>
 
int main ()
{
   /* local variable definition */
   int a = 10;

   /* while loop execution */
   while( a < 20 )
   {
      printf("value of a: %d\n", a);
      a++;
      for(int i=0;i<2;i++){
      if( a > 15)
      {
         /* terminate the loop using break statement */
          break;
      }
      }
   }
 
   return 0;
}
