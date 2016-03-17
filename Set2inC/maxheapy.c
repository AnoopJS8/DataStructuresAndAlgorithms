//FileName: Max_heapify.c
//Author: Nyah Check, Chairman @ INK Corp.
//This program illustrates the Max _heapify algorithm for sorting numbers.
//Usage: This is a freeware and should be licenced following the GNU Public licence.
//INK Corp. 2012.
 
#include <stdio.h>
#include <stdlib.h>
 
#include <assert.h> //this header checks for errors with the  algorithm.
 
#define HEAPSIZE(A) sizeof(A)/sizeof(int) //determines the heap size which is <= sizeof(A).
#define LEFT(i) i<<1          // this macro doubles i.
#define RIGHT(i) (i<<1) + 1   //this macro computes 2(i) + 1.
#define PARENT(i) i>>1        //this macro computes the floor(i/2).
 
int MAX_HEAPIFY(unsigned int A[], unsigned int n);
int BUILD_MAX_HEAP(unsigned int A[]);
 
unsigned int A[] = {27, 17, 3, 16, 13, 10, 1,5 , 7, 12, 4, 8, 9, 0};
unsigned int i, largest,errno;
 
int main(void)
{
   unsigned int m = 0;
 
    printf("\nThis program sorts input in decreasing order using the Max_heapify algorithm.");
 
    printf("\nOriginal Array: ");
    for ( unsigned int i = 0; i < HEAPSIZE(A); i++)
        printf(" %d ", A[i]);
 
    //printf("\nImplementing Heap sort.....");
    /*for ( t = 0, q = 1; t < HEAPSIZE(A)/2; t++, q++)
        MAX_HEAPIFY(A, t);
        assert(k); //this checks for the return value of the MaxHeap algo.
     *
     */
     BUILD_MAX_HEAP(A);
 
    printf("\nFinal Array: ");
    errno = HEAPSIZE(A);
    for ( m = 0; m < HEAPSIZE(A); m++)
        printf(" %d ", A[m]);
 
    if ((int)m > errno)  //this checks whether the loop read past the end of array.
        fprintf(stderr, "Final heap Error: function read past end of array.");
        exit(EXIT_FAILURE);
 
    return 0;
}
 
//This function uses the max heapify algo to sort numbers in an array.
int MAX_HEAPIFY(unsigned int A[], unsigned int n)
{
    unsigned int l, r;
    l = LEFT(n);
    r = RIGHT(n);
    largest = n;
 
    if (l <= HEAPSIZE(A) && A[l] > A[n])
    {
        largest = l;
    }
 
    else if ( r <= HEAPSIZE(A) && A[r] > A[largest])
    {
        largest = r;
    }
 
    else if( largest != n)
    {
        i = A[n];
        A[n] = A[largest];
        A[largest] = i;
        MAX_HEAPIFY(A, largest);
    }
 
    return 1;
}
 
//This program calls the heap_max function recursively to sort the numbers.
int BUILD_MAX_HEAP(unsigned int A[])
{
    int i, z;
    z = HEAPSIZE(A);
    printf("\nTotal heap: %d ", z);
 
    for ( i = z / 2; i < z +1; i++)
    {
        printf("\nI: %d", i);
        MAX_HEAPIFY(A, i);
        printf("\nExecuted correctly.\n");
    }
 
    return 1;
}
