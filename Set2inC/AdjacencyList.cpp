#include<stdio.h>
#include<stdlib.h>
struct AdjListNode
{
    int dest;
    struct AdjListNode *next;
};

struct AdjList
{
    struct AdjListNode *head;
};

struct Graph
{
    int V;
    struct AdjList* array;
};

struct AdjListNode* newAdjListNode(int _dest)
{
    struct AdjListNode* newNode=(struct AdjListNode*)malloc(sizeof(struct AdjListNode));
    newNode->dest=_dest;
    newNode->next=NULL;
    return newNode;
};

//A utility function that creates a graph of VC vertices.

struct Graph* createGraph(int V)
{
    struct Graph* graph=(struct Graph*)malloc(sizeof(struct Graph));
    graph->V=V;

    //create an array of adjacency matrix of size V.

    graph->array=(struct AdjList*)malloc(sizeof(struct AdjList)*V);

    //initialize each adjacency list as empty by making head NULL
    int i;
    for(i=0;i<V;i++)
    {
        graph->array[i].head=NULL;

    }

     return graph;

};

// Adds an edge to an undirected graph
void addEdge(struct Graph* graph,int src,int dest)
{
    // Add an edge from src to dest.  A new node is added to the adjacency
    // list of src.  The node is added at the begining
    struct AdjListNode* newNode=newAdjListNode(dest);
    newNode->next=graph->array[src].head;
    graph->array[src].head=newNode;

    // Since graph is undirected, add an edge from dest to src also
  /*  newNode=newAdjListNode(src);
    newNode->next=graph->array[dest].head;
    graph->array[dest].head=newNode;
*/
}

// A utility function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph)
{
    int v;
    for (v = 0; v < graph->V; ++v)
    {
        struct AdjListNode* pCrawl = graph->array[v].head;
        printf("\n Adjacency list of vertex %d\n head ", v);
        while (pCrawl)
        {
            printf("-> %d", pCrawl->dest);
            pCrawl = pCrawl->next;
        }
        printf("\n");
    }
}

// Driver program to test above functions
int main()
{
    // create the graph given in above fugure
    int V = 5;
    struct Graph* graph = createGraph(V);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // print the adjacency list representation of the above graph
    printGraph(graph);

    return 0;
}
