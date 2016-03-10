
#include<stdio.h>

int main(){
   // int B[2][2][2]={0};//{{{'9'}}};
    int B[3][3][3]={0};
    int i,j,k;
//    for(i=0;i<2;i++)
//    {
//        for(j=0;j<2;j++)
//        {
//            for(k=0;k<2;k++)
//            {
//                printf("%d ",B[i][j][k]);
//            }printf("\n");
//        }
//    }
//    int x=0,y=1,z=0;
//    B[x][y][z]+=1;
//    printf("%d \n",B[x][y][z]);
        for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            for(k=0;k<3;k++)
            {
                //printf("%d ",B[i][j][k]);
                printf("%d %d %d \n",i,j,k);
            }printf("\n");
        }printf("\n");
    }printf("\n");
    return 0;
}
