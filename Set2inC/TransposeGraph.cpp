//DFS using STACK
#include<stdio.h>
#include<stdlib.h>
#include<stack>
#include<iostream>

using namespace std;
//static int time;

//Creating the structure for the Node vertices
struct Node{
    int key;
    char color;
    struct Node* p;
    int d_time; //discovered time
    int f_time;//finishing time

    struct Node *next;
};

//Creating a Graph structure which contains an array of node vertices
struct Graph{
    int V;
    struct Node** Array;
};

//An utility function to create new vertices node
struct Node* newNode(int _key)
{
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->key=_key;
    newNode->color='W';//white
    newNode->p=NULL;
    newNode->d_time=0;
    newNode->f_time=0;
    newNode->next=NULL;
    return newNode;
};
//An utility function to create a Graph by passing the no of vertices needed
struct Graph* createGraph(int _v){

    struct Graph* graph=(struct Graph*)malloc(sizeof(struct Graph));
    graph->V=_v;
    graph->Array=(struct Node **)malloc(sizeof(struct Node* )*graph->V); //check the diff between bfs as well
    int i;

//The above thing we cant do as we havent declared memory for the pointers present in the array.So we have to first allocate memory for them.
    for(i=0;i<_v;i++)
    {
        graph->Array[i]=(struct Node *)malloc(sizeof(struct Node));
    }
    for(i=0;i<graph->V;i++){
        graph->Array[i]->key=-1;
        graph->Array[i]->color='W';
        graph->Array[i]->p=NULL;
        graph->Array[i]->d_time=0;
        graph->Array[i]->f_time=0;
        graph->Array[i]->next=NULL;
    }

    return graph;
};

void addVertices(struct Graph* graph,int _key)
{
    graph->Array[_key]->key=_key;
}

void addEdge(struct Graph* graph,int src,int dest)
{
    struct Node* newnode=newNode(dest);//(struct AdjListNode*)malloc(sizeof(struct AdjListNode));
    newnode->next=graph->Array[src]->next;
    graph->Array[src]->next=newnode;

}

struct Graph* TransposeGraph(struct Graph* g)
{
//    struct Graph* gT=(struct Graph*)malloc(sizeof(Graph));
//    gT->V=g->V;
//    gT->Array=(struct Node **)malloc(sizeof(Node *)*gT->V);
//    int i;
//    for(i=0;i<gT->V;i++)
//    {
//        gT->Array[i]=(struct Node*)malloc(sizeof(struct Node));
//    };
    struct Graph* gT;
    gT= createGraph(g->V);

    int i,src,dest;
    for(i=0;i<gT->V;i++)
    {
            addVertices(gT,i);
    }

    for(i=0;i<gT->V;i++)
    {
        struct Node* pCrawl = g->Array[i]->next;
        while (pCrawl)
        {
            //gT->Array[pCrawl->key]=

            src=pCrawl->key;
            dest=i;
           // cout<<src<<endl;
            addEdge(gT,src,dest);
            pCrawl = pCrawl->next;
        }

    }
    return gT;
};
struct Node* findVertex(Graph *g,int key)
{
    return g->Array[key];
}

void CopyAttributes(Graph *g,Node* srcNode){

for(int i=0;i<g->V;i++){
    struct Node* head=g->Array[i];
    while(head)
    {
        if(head->key==srcNode->key)
        {
            head->color=srcNode->color;
            head->d_time=srcNode->d_time;
            head->f_time=srcNode->f_time;
            head->p=srcNode->p;//cant do next because it would be pointing to a different address
      //      cout<<"-"<<head->color<<"-";
            //cout<<"-"<<srcNode->color<<"-";
        }
        head=head->next;
    }
}
    //cout<<endl;
}
/*
void DFS(struct Graph* G)
{
    static int time=0;

}
*/
void DFS_Visit(struct Graph* G,int _u)
{
    struct Node* u=findVertex(G,_u);
    struct Node* v,*x;
    static int time=0;//even without static will do as we are not making recursive call
    stack<Node *>Stack;
    time+=1;
    //u->key=_u;
    u->d_time=time;
    u->color='G';

    //Since this the first node we have to this
    CopyAttributes(G,u);
    Stack.push(u);
    cout<<u->key<<" ";
    //v=Stack.top();
    while(!Stack.empty())
    {
        v=Stack.top();

        struct Node *u_next=G->Array[v->key]->next;

    while(u_next!=NULL && u_next->color!='W')
        u_next=u_next->next;


            if(u_next && u_next->color=='W')   //These two nested if 's can be combined into one as if(cond1&&cond2);
            {

                cout<<(u_next->key)<<" ";//<<u_next->color<<"+ ";
                u_next->color='G';
                u_next->p=v;
                u_next->d_time=time+1;

                CopyAttributes(G,u_next);
                //findVertex(G,u_next->key)->d_time=u_next->d_time;
                //cout<<"B"<<endl;
                Stack.push(u_next);

            }else{
            Stack.pop();
            //cout<<v->key<<"?";
            time=time+1;
            v->f_time=time;//u_next->f_time=time;//x->f_time=time;//v->f_time=time;//x->f_time=time;
            v->color='B';//u_next->color='B';//v->color='B';//x->color='B';
            CopyAttributes(G,v);

        }
        //cout<<"Y";
    }
   // cout<<v->key;

}
// A utility function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph)
{
    int v;
    for (v = 0; v < graph->V; ++v)
    {
        struct Node* pCrawl = graph->Array[v]->next;
        printf("\n Adjacency list of vertex %d\n head ", v);
        while (pCrawl)
        {
            printf("-> %d", pCrawl->key);
            pCrawl = pCrawl->next;
        }
        printf("\n");
    }
}

void printGraphT(struct Graph* graph)
{
    int v;
    //cout<<"Inside"<<endl;
    //cout<<graph->V<<" ";
    for (v = 0; v < graph->V; ++v)
    {
        struct Node* pCrawl = graph->Array[v]->next;
        printf("\n Adjacency list of vertex %d\n head ", v);
        while (pCrawl)
        {
            printf("-> %d", pCrawl->key);
            pCrawl = pCrawl->next;
        }
        printf("\n");
    }
}
int main()
{
    // create the graph given in above fugure
    int V = 5;
    struct Graph* graph = createGraph(V);
//    addVertices(graph,0);
//    addVertices(graph,1);
//    addVertices(graph,2);
//    addVertices(graph,3);
//    addVertices(graph,4);
//    //addVertices(graph,4);
//    //addVertices(graph,0);
//    addEdge(graph, 0, 2);
//    addEdge(graph, 0, 1);
//    addEdge(graph, 1, 2);
//    addEdge(graph, 2, 3);
//    addEdge(graph, 2, 0);
//    //addEdge(graph, 2, 3);
//    addEdge(graph, 3, 3);
//    addEdge(graph, 1, 4);
    addVertices(graph,0);
    addVertices(graph,1);
    addVertices(graph,2);
    addVertices(graph,3);
    addVertices(graph,4);

    addEdge(graph,0, 1);
    addEdge(graph,1, 2);
    addEdge(graph,2, 3);
    addEdge(graph,3, 0);
    addEdge(graph,2, 4);
    addEdge(graph,4, 2);

    printGraph(graph);
    printf("\n");
    printf("Transpose\n");
    struct Graph* gT;// = createGraph(V);
    gT=TransposeGraph(graph);
    printGraphT(gT);
    cout<<endl;
    cout<<"Done"<<endl;
    return 0;
}
