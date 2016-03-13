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
//    for(i=0;i<graph->V;i++){
//        graph->Array[i]->key=-1;
//        graph->Array[i]->color='W';
//        graph->Array[i]->p=NULL;
//        graph->Array[i]->d_time=0;
//        graph->Array[i]->f_time=0;
//        graph->Array[i]->next=NULL;
//    }

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

struct Node* findVertex(Graph *g,int key)
{
    return g->Array[key];
}

void CopyAttributes(Graph *g,Node* srcNode){
    //struct Node* head=g->Array[srcNode->key];
   // G->Array[v->key]->next;
//    head->color=srcNode->color;
//    head->d_time=srcNode->d_time;
//    head->f_time=srcNode->f_time;
//    head->p=srcNode->p;
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
        //if(v->color!='B')
            //cout<<(v->key)<<" ";//<<v->color;//cout<<(v->key)<<" "<<v->color<<" "<<v->d_time<<endl;//cout<<"v->"<<(v->key)<<" "<<endl;
        //cout<<(v->key)<<" ";
        struct Node *u_next=G->Array[v->key]->next;
        //cout<<"Y";
       /* if(u_next->next==NULL)
        {

        }else{*/
      //  cout<<"H";
       // cout<<u_next;
//        while(u_next->next!=NULL)
//         {
//            cout<<"H";
//          if(u_next->color=='W')
//          {
//               // cout<<"-"<<u_next->key<<"-" ;
//                break;
//          }
//          else
//             {
//
//              u_next=u_next->next;
//              //cout<<u_next->key;
//              }
//
//        }
    while(u_next!=NULL && u_next->color!='W')
        u_next=u_next->next;

    //}
        //cout<<"X";
        //if((u_next->next->key)!=NULL)
        //cout<<"Adj->"<<(u_next->key)<<endl;//"Adj2"<<(u_next->next->key)<<endl;

       // if(u_next)
       // {
        //cout<<"X"<<endl;
            if(u_next && u_next->color=='W')   //These two nested if 's can be combined into one as if(cond1&&cond2);
            {
               // cout<<"In If"<<" "<<u_next->key<<" ";
                //cout<<(u_next->key)<<" ";
              //  cout<<u_next->color<<" ";
                //cout<<(v->key)<<" ";
                cout<<(u_next->key)<<" ";//<<u_next->color<<"+ ";
                u_next->color='G';
                u_next->p=v;
                u_next->d_time=time+1;
               // cout<<u_next->color<<" ";
                //findVertex(G,u_next->key)->color='G';//we have to perform thisbecause the other node in the array list wont get updated,and vice-versa
                //x=findVertex(G,u_next->key);
                //cout<<x->color<<endl;
                //x->color='G';
                //x->p=v;//findVertex(G,u_next->key)->p=v;
                //x->d_time=u_next->d_time;
               // cout<<"A"<<endl;
                CopyAttributes(G,u_next);
                //findVertex(G,u_next->key)->d_time=u_next->d_time;
                //cout<<"B"<<endl;
                Stack.push(u_next);
               //cout<<v->key<<"#";
               // v=Stack.top();
                //u_next=u_next->next;
               // cout<<"XIN";
            }else{
            //v=Stack.top();//x=Stack.top();
            //cout<<"-"<<Stack.size()<<"-";
            //cout<<"-"<<(Stack.top()->key)<<"-";
            ////****Stack.pop();
            //cout<<"-"<<Stack.size()<<"-";
            //v->color='B';//x->color='B';
            Stack.pop();
            //cout<<v->key<<"?";
            time=time+1;
            v->f_time=time;//u_next->f_time=time;//x->f_time=time;//v->f_time=time;//x->f_time=time;
            v->color='B';//u_next->color='B';//v->color='B';//x->color='B';
            //CopyAttributes(G,u_next);
            //cout<<"C"<<endl;
            CopyAttributes(G,v);
            //cout<<"D"<<endl;
            //x=findVertex(G,u_next->key);
            //x->color='B';
            //x->f_time=time;
            //findVertex(G,u_next->key)->color='B';
            //findVertex(G,u_next->key)->f_time=time;
            //v=Stack.top();
            //Stack.pop();
           // cout<<"Here2"<<endl;
            //cout<<(v->key)<<" ";
           // cout<<"YIN";
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
    //addVertices(graph,4);
    //addVertices(graph,0);
    addEdge(graph, 0, 2);
    addEdge(graph, 0, 1);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 3);
    addEdge(graph, 2, 0);
    //addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);
    addEdge(graph, 1, 4);
    //addEdge(graph, 4, 1);
    //addEdge(graph, 3, 0);
    //addEdge(graph, 3, 3);
    //addEdge(graph, 3, 4);

    // print the adjacency list representation of the above graph
    printGraph(graph);
    printf("\n");
    printf("DFS Traversal\n");
    DFS_Visit(graph,0);
    cout<<endl;
    cout<<"Done"<<endl;
    return 0;
}
