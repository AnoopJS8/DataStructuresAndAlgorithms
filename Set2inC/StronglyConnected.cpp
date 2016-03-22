// Implementation of Kosaraju's algorithm to print all SCCs
#include<iostream>
#include<list>
#include<stack>

using namespace std;

class Graph{

    int V;
    list<int> *adj; //an Array of adjacent lists

    //Filss stack with vertices in increasing order of finishing times
    //Top element of the stack has the maximum finishing time
    void fillOrder(int v,bool visited[],stack<int> &Stack);
    //A recursive function to print DFS starting from vertex v
    void DFSUtil(int v,bool visited[]);
public:
    Graph(int v);
    ~Graph();
    void addEdges(int u,int v); //edge :> u->v
    Graph getTranspose();
    void printGraph();
    void printSCCs();//the main function that finds and prints strongly connected components
};

Graph::Graph(int v)
{
    this->V=v;
    adj=new list<int>[v];
}

Graph::~Graph(){

    delete [] adj;
}
void Graph::addEdges(int u,int v)
{
    adj[u].push_back(v);//Add v to u's list.
}

void Graph::DFSUtil(int v,bool visited[])
{
    //Here we mark the current node and print it i.e with the largest finishing time
    visited[v]=true;
    cout<<v<<" ";
    //cout<<"Hi";
    //Now we have to recur for all the vertices adjacent to this vertex i.e DFS
    list<int>::iterator i;
    for(i=adj[v].begin();i!=adj[v].end();i++)
    {
        if(!visited[*i])
            DFSUtil(*i,visited);

    }

}

Graph Graph::getTranspose()
{
    Graph g(this->V);
    list<int>::iterator i;
    for(int v=0;v<this->V;v++)
    {
        for(i=adj[v].begin();i!=adj[v].end();i++)
        {
            g.adj[*i].push_back(v);
        }

    }
    return g;

}

//This is the first DFS to be done with keeping the track for the finishing times in increasing order
void Graph::fillOrder(int v,bool visited[],stack<int> &Stack)
{
    //Mark the current node as visited
    visited[v]=true;
    //Recur for all the vertices adjacent to it.
    list<int>::iterator i;
    for(i=adj[v].begin();i!=adj[v].end();i++)
    {
        if(!visited[*i])
            fillOrder(*i,visited,Stack);
    }
    Stack.push(v);//All the verices reachable from v has been reached by now ,So push into the Stack.

}

void Graph::printSCCs()
{
    stack<int> Stack;
    //cout<<1<<endl;
    //Markind all the vertices as not visited for the first DFS.
    bool *visited=new bool[V];
    for(int i=0;i<V;i++)
        visited[i]=false;

    // Fill vertices in stack according to their finishing times i.e the First DFS->fillOrder Utility Function
    for(int v=0;v<V;v++)
    {
        if(!visited[v])
        {
            fillOrder(v,visited,Stack);
        }
    }

    //Now we create a reversed Graph
    //cout<<2<<endl;
    Graph gT=getTranspose();

    //Mark all the vertices as Not Marked for the Second DFS
    for(int i=0;i<V;i++)
        visited[i]=false;
    //cout<<3<<endl;
    // cout<<Stack.top();
    //Now we process all the vertices in the Stack order
    while(!Stack.empty())
    {
        int top;
        top=Stack.top();
        Stack.pop();
        //cout<<3<<endl;
        // Print Strongly connected component of the popped vertex
        if (visited[top]==false)
            {
                gT.DFSUtil(top,visited);
                cout<<endl;
            }


    }

}
void Graph::printGraph()
{
    int vr;
    list<int>::iterator i;
    for (vr = 0; vr < V; ++vr)
    {

        cout<<"\n Adjacency list of vertex "<<vr<<"\n head ";//, v);
        for(i=adj[vr].begin();i!=adj[vr].end();++i)
        {
            cout<<"-> "<<*i;
        }
        cout<<endl;
    }
}
int main()
{
     // Create a graph given in the above diagram
    Graph g(5);
    g.addEdges(1, 0);
    g.addEdges(0, 2);
    g.addEdges(2, 1);
    g.addEdges(0, 3);
    g.addEdges(3, 4);
    //g.printGraph();
    cout << "Following are strongly connected components in given graph \n";
    g.printSCCs();

    return 0;
}
