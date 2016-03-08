#include <stdio.h>
int main(){
   printf("Current time: %s",__TIME__);   //calculate the current time
   printf("\nCurrent date: %s",__DATE__);   //calculate string containing current DATE
   printf("\nCurrent file: %s",__FILE__);   //calculate String containing the file name
   printf("\nCurrent std: %d",__STDC__);   //calculate If follows ANSI standard C, then value is a nonzero integer
   printf("\nCurrent line: %d\n",__LINE__);   //calculate Integer representing the current line number
}
