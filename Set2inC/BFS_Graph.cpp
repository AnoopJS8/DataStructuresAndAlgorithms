// Program to print BFS traversal from a given source vertex. BFS(int s)
// traverses vertices reachable from s.
#include<iostream>
#include<list>

using namespace std;

// This class represents a un-directed graph using adjacency list representation

class Graph
{
    int V;
    list<int> *array;  // Pointer to an array containing adjacency lists

public:
    Graph(int V);
    void addEdge(int v,int w);//v=src ,w=dest  ;// function to add an edge to graph
    void BFS(int s);//Prints BFS traversal from the given source s.
    void printGraph();
};

Graph::Graph(int V)
{
    this->V=V;
    array=new list<int>[V];
}

void Graph::addEdge(int v,int w)
{
    array[v].push_back(w); //array[v].push_front(w);// Add w to v’s list.
  //  array[w].push_back(v);//due to un directedness
}
void Graph::printGraph()
{
    int vr;
    list<int>::iterator i;
    for (vr = 0; vr < V; ++vr)
    {

        cout<<"\n Adjacency list of vertex "<<vr<<"\n head ";//, v);
        for(i=array[vr].begin();i!=array[vr].end();++i)
        {
            cout<<"-> "<<*i;
        }
        cout<<endl;
    }
}
void Graph::BFS(int s)
{
    //Mark all the vertices as not visited
    bool *visited=new bool[V];
    for(int i=0;i<V;++i)
        visited[i]=false;
    //Create a queue for BFS
    list<int> queue;
    visited[s]=true;
    queue.push_back(s);

    // 'i' will be used to get all adjacent vertices of a vertex
    list<int>::iterator i;

    while(!queue.empty())
    {
        // Dequeue a vertex from queue and print it
        s=queue.front();
        cout<<s<<" ";
        queue.pop_front();

        // Get all adjacent vertices of the dequeued vertex s
        // If a adjacent has not been visited, then mark it visited
        // and enqueue it

        for(i=array[s].begin();i!=array[s].end();++i)
        {

            if(!visited[*i])
            {
                visited[*i]=true;
                queue.push_back(*i);
            }
        }
    }

}
int main()
{
    Graph g(5);
    g.addEdge(0, 1);
    g.addEdge(0, 4);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 3);
    g.addEdge(3, 4);

    //g.printGraph();
    g.BFS(2);
    return 0;
}
