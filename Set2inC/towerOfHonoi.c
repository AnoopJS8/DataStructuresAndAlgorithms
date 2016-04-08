/*Tower of Honoi

Objective: To move the disks to peg3 from peg1 using peg2 as intermediate.

T(n)=2*T(n-1) + 1

Note: Can only move 1 disk at a time.
      Longer disk can never be abonve smaller disk.

Algorithm:

To move n disks from peg A to C
1. Move (n-1) disk from peg A to B using C as intermediate peg.
2.Move nth disk from peg A to C.
3.Move (n-1)disk from B to C using A as Intermediate.

*/

#include<stdio.h>
void towerHanoi(int n,char frompeg,char topeg,char interpeg)
{ /* If only 1 disk, move it from peg to topeg */
	  if(n==1)
	    { printf("\nMove disk 1 from peg %c to peg %c",frompeg,topeg);
	      return;
	    }
	  /* Move top n-1 disks from A to B, using C as intermediate */
	  towerHanoi(n-1,frompeg,interpeg,topeg);
	  /* Move remaining disk from A to C */
	  printf("\nMove disk %d from peg %c to peg %c",n,frompeg,topeg);
	  /* Move n-1 disks from B to C using A as intermediate */
	  towerHanoi(n-1,interpeg,topeg,frompeg);
}
int main()
	{ int n=3;
	  printf("The Tower of Hanoi involves the moves :\n\n");
	  towerHanoi(n,'A','C','B');
	  return 0;
	}
