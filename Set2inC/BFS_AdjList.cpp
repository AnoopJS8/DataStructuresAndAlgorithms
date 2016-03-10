#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
#include<queue>
using namespace std;

struct AdjListNode{
    int key;
    char color;
    //struct AdjListNode *p;
    int p;
    int d;
    struct AdjListNode* next;
};
/*
struct AdjList{
    int key;
    char color;
    struct AdjListNode *p;
    int d;
    struct AdjListNode* next;
    //struct AdjListNode *head;  //incase of characters we have to add another variable into it.
};
*/
struct Graph {
    int V;
    struct AdjListNode *ArrayLink;
};

struct AdjListNode* newAdjListNode(int key)
{
    struct AdjListNode* newnode=(struct AdjListNode*)malloc(sizeof(struct AdjListNode));
    newnode->key=key;
    newnode->color='W';
    newnode->p=-1;
    newnode->d=INT_MAX;
    newnode->next=NULL;
    return newnode;
};

struct Graph* createGraph(int v)
{
    struct Graph* graph=(struct Graph*)malloc(sizeof(struct Graph));
    graph->V=v;
    graph->ArrayLink=(struct AdjListNode*)malloc(sizeof(struct AdjListNode)*v);//graph->Array=(struct AdjList*)calloc(sizeof(struct AdjList),V);
    int i=0;
    for(i=0;i<v;i++){
        graph->ArrayLink[i].key=-1;
        graph->ArrayLink[i].color='W';
        graph->ArrayLink[i].p=-1;
        graph->ArrayLink[i].d=INT_MAX;
        graph->ArrayLink[i].next=NULL;
    }
    return graph;

}
void addVertices(struct Graph* graph,int _key)
{
    graph->ArrayLink[_key].key=_key;
}

void addEdge(struct Graph* graph,int src,int dest)
{
    struct AdjListNode* newnode=newAdjListNode(dest);//(struct AdjListNode*)malloc(sizeof(struct AdjListNode));
    newnode->next=graph->ArrayLink[src].next;
    graph->ArrayLink[src].next=newnode;

}
/*
struct AdjList *findVertex(Graph *g,int key,int v)
{
    int i;
    //for (i = 0; i < v; ++i)
    //{
        return (g->Array[i])
   // }
};
*/

struct AdjListNode findVertex(Graph *g,int key)
{
    return g->ArrayLink[key];
}
//BFS
void BFS(Graph *g,int s)
{
//    struct AdjListNode *vertex=findVertex(g,s);
    g->ArrayLink[s].color='G';
    g->ArrayLink[s].d=0;
    queue<int> Queue;
    Queue.push(s);
    int u;
    while(!Queue.empty())
    {
        u=Queue.front();
        printf("%d ", u);
        Queue.pop();
        struct AdjListNode *pcrawl=g->ArrayLink[u].next;
        while(pcrawl)
        {
            if(pcrawl->color=='W')
            {
                //printf(" %d", pcrawl->key);
                pcrawl->color=='G';
                pcrawl->d=findVertex(g,u).d+1;
                pcrawl->p=u;
                Queue.push(pcrawl->key);
                pcrawl=pcrawl->next;
            }
        }
        g->ArrayLink[u].color='B';

    }


}

// A utility function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph)
{
    int v;
    for (v = 0; v < graph->V; ++v)
    {
        struct AdjListNode* pCrawl = graph->ArrayLink[v].next;
        printf("\n Adjacency list of vertex %d\n head ", v);
        while (pCrawl)
        {
            printf("-> %d", pCrawl->key);
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
    addVertices(graph,0);
    addVertices(graph,1);
    addVertices(graph,2);
    addVertices(graph,3);
    addVertices(graph,4);
    //addVertices(graph,0);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // print the adjacency list representation of the above graph
    printGraph(graph);
    printf("\n");
    printf("BFS Traversal\n");
    BFS(graph,2);

    return 0;
}
