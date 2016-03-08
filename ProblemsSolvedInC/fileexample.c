#include<stdio.h>

int main(){

FILE *ifp, *ofp;
char *mode = "w";
char username[10];
int score;
char outputFilename[] = "out111.list";

ifp = fopen("in111.list", mode);

if (ifp == NULL) {
  fprintf(stderr, "Can't open input file in.list!\n");
  exit(1);
}

ofp = fopen(outputFilename, "w");

if (ofp == NULL) {
  fprintf(stderr, "Can't open output file %s!\n",
          outputFilename);
  exit(1);
}

while (!feof(ifp)) {
  if (fscanf(ifp, "%s %d", username, &score) != 2)
    break;
  fprintf(ofp, "%s %d", username, score+10);
}
fclose(ifp);
return 0;
}
