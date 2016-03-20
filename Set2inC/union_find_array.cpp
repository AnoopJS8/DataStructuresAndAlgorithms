/*
Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).
 ____________
|-1| -1 | -1 |
--------------
 0 | 1  |  2 |

Edge 0-1: Find the subsets in which vertices 0 and 1 are. Since they are in different subsets, we take the union of them. For taking the union, either make node 0 as parent of node 1 or vice-versa.

1  -1  -1
0   1   2    <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})

Edge 1-2: 1 is in subset 1 and 2 is in subset 2. So, take union.

1   2  -1
0   1   2    <----- 2 is made parent of 1 (2 is now representative of subset {0, 1, 2})

Edge 0-2: 0 is in subset 2 and 2 is also in subset 2. Hence, including this edge forms a cycle.

How subset of 0 is same as 2?
0->1->2 // 1 is parent of 0 and 2 is parent of 1
*/

// A union-find algorithm to detect cycle in a graph
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Edge{
    int src,dest;
};

struct Graph{
    // V-> Number of vertices, E-> Number of edges
    int V,E;

    // graph is represented as an array of edges since it is a undirected graph two edges rep one
    struct Edge *edge;

};

// Creates a graph with V vertices and E edges

struct Graph* createGraph(int V,int E)
{
    struct Graph* graph=(struct Graph*)malloc(sizeof(struct Graph));
    graph->V=V;
    graph->E=E;

    graph->edge=(struct Edge*)malloc(sizeof(struct Edge)*graph->E);
    return graph;
};

//An utility function to find the set i.e the root or parent of an element i belongs to
//An element here is represented by the indices of the array.i.e element 0 refer to the index 0.And the vale at index 0 refers to its parent.
int findSet(int parent[],int i)
{
    if (parent[i]==-1)
        return i;
    //parent[i]=findSet(parent,parent[i]);
    //return parent[i];
    return findSet(parent,parent[i]);
}

//An utility function to do union of two sets

void Union(int parent[],int x,int y)
{
    int xset=findSet(parent,x);
    int yset=findSet(parent,y);

    parent[xset]=yset;
}

// The main function to check whether a given graph contains cycle or not

int isCycle(struct Graph* graph)
{
    //Allocate memory for creating V subsets
    int *parent=(int *)malloc(sizeof(int)*graph->V);

    // Initialize all subsets as single element sets
    memset(parent,-1,sizeof(int)*graph->V);
    // Iterate through all edges of graph, find sets of both
    // vertices of every edge, if both subsets are same, then there is
    // cycle in graph.

    for(int i=0;i<graph->E;i++)
    {
        int x=findSet(parent,graph->edge[i].src);
        int y=findSet(parent,graph->edge[i].dest);
        printf("%d %d",x,y);
        printf("\n");
        if(x==y)
            return 1;

        Union(parent,x,y);
    }
    return 0;
}

// Driver program to test above functions
int main()
{
    /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
    struct Graph* graph = createGraph(3, 3);

    // add edge 0-1
    graph->edge[0].src = 0;
    graph->edge[0].dest = 1;

    // add edge 1-2
    graph->edge[1].src = 1;
    graph->edge[1].dest = 2;

    // add edge 0-2
    graph->edge[2].src = 0;
    graph->edge[2].dest = 2;

    if (isCycle(graph))
        printf( "Graph contains cycle" );
    else
        printf( "Graph doesn't contain cycle" );

    return 0;
}
