#include<stdio.h>

int main(){
int number;
FILE *fp;
char *mode="w";
fp = fopen("insertion_data.list",mode);
if (fp == NULL) {
  fprintf(stderr, "Can't open the input file insertion_data.txt!\n");
  exit(0);
}

while(!feof(fp))
{
if(fscanf(fp,"%d \n",&number)==2)
break;
fprintf(fp,"%d",number);
}
fclose(fp);
}

