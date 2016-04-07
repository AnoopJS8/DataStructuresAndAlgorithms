#include<stdio.h>
#include<stdlib.h>

#define MAX_TREE_HT 100

struct MinHeapNode
{
    char data;
    unsigned freq;
    struct MinHeapNode *left,*right;
};

struct MinHeap
{
    unsigned Size;
    unsigned Capacity;
    struct MinHeapNode **Array;  //Array of minHeap node pointers

};

//Utility function to allocate a new min heap node for a given  character
//and frequency .

struct MinHeapNode *newNode(char data,int freq)
{
    struct MinHeapNode* temp=(struct MinHeapNode *)malloc(sizeof(struct MinHeapNode));
    temp->data=data;
    temp->freq=freq;
    temp->left=temp->right=NULL;

};

//An utility function to create a Min Heap of given Capacity

struct MinHeap* createMinHeap(unsigned capacity)
{
    struct MinHeap* minHeap=(struct MinHeap* )malloc(sizeof(struct MinHeap));
    minHeap->Size=0; //current size is zero
    minHeap->Capacity=capacity;
    minHeap->Array=(struct MinHeapNode **)malloc(sizeof(struct MinHeapNode *)*minHeap->Capacity);
    return minHeap;
};

//A utility function to swap two min heap Nodes

void swapMinHeapNode(struct MinHeapNode **a,struct MinHeapNode **b)
{
    struct MinHeapNode *t;
    t=*a;
    *a=*b;
    *b=t;
}

//Standard MinHeapify function
void minHeapify(struct MinHeap* minHeap,int index)
{
    //int smallest=index;
    int smallest;
    int leftChildIndx=2*index + 1;
    int rightChildIndx=2*index + 2;

    if(leftChildIndx<minHeap->Size && minHeap->Array[leftChildIndx]->freq<minHeap->Array[index]->freq)
    {
        smallest=leftChildIndx;
    }else{
        smallest=index;
    }
    if(rightChildIndx<minHeap->Size && minHeap->Array[rightChildIndx]->freq < minHeap->Array[smallest]->freq)
    {
        smallest=rightChildIndx;
    }
    if(smallest != index)
    {
        swapMinHeapNode(minHeap->Array[index],minHeap->Array[smallest])
        minHeapify(minHeap,smallest); //After swapping the element at the index now becomes the smallest and smallest index becomes not smallest so this step
        //and thus the root of this subtree becomes the least than both of its children.
    }

}

//An utility function to check if the heap size is 1 or not.

int isSizeOne(struct MinHeap* minHeap)
{
    return (minHeap->Size==1);
}

//A standard function to extract the minimum value node from heap i.e Priority Queue Property

struct MinHeapNode* extractMin(struct MinHeap* minHeap)
{
    struct MinHeapNode* temp=MinHeap->Array[0];
    MinHeap->Array[0]=MinHeap->Array[MinHeap->Size-1];
    --minHeap->Size;
    minHeapify(MinHeap,0);
    return temp;
};

//A utility function to insert a new node into the min heap
void insertMinHeap(struct MinHeap* minHeap,struct MinHeapNode* minHeapNode)
{
    minHeap->Size=minHeap->Size + 1;
    int i=minHeap->Size-1;
    while(i && minHeapNode->freq<minHeap->Array[(i-1)/2]->freq)
    {
        minHeap->Array[i]=minHeap->Array[(i-1)/2];
        i=(i-1)/2;
    }
    minHeap->Array[i]=minHeapNode;

}

//A standard function to build min heap

void buildMinHeap(struct MinHeap* minheap)
{
    int n=minheap->Size-1;
    int i;
    for(i=(n-1)/2;i>=0;i--)
    {
        minHeapify(minheap,i);
    }

}

//A utility function to print an array of size n

void printArray(int A[],int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        printf("%d ",A[i]);

    }
    printf("\n");
}

int isLeaf(struct MinHeapNode* root)
{
    return !(root->left) && !(root->right);
}

//Function to create a min heap of capacity equal to size and insert all the characters of data[] in MinHeap.
//Initially size of min heap equal to the Capacity

struct MinHeap* createAndBuildMinHeap(char data[],int freq[],int size)
{
    struct MinHeap* minHeap=createMinHeap(size);
    int i;
    for(i=0;i<size;i++)
    {
        minHeap->Array[i]=newNode(data[i],freq[i]);
    }
    minHeap->Size=size;
    buildMinHeap(MinHeap);
};
