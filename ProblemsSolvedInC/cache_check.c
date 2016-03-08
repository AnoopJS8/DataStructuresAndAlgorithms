#include<stdio.h>

enum cache_policy {
  LRU,          /* replace least recently used block (perfect LRU) */
  Random,       /* replace a random block */
  FIFO          /* replace the oldest block in the set */
};

int main()
{
enum cache_policy cp;

printf("%d \n",LRU);
printf("%d \n",Random);
printf("%d \n",FIFO);

return 0;

}

