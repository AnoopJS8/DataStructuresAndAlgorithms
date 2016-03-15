#include<iostream>
#include<cstdlib>
#include<map>

using namespace std;

struct Node{
    int data;
    Node* parent;
    int Rank;
};

std::map<int,Node*> Map;

void MakeSet(int data)
{
    struct Node* node=new Node();
    node->data=data;
    node->parent=node;
    node->Rank=0;
    Map[data]=node;
}

/*
     * Find the representative recursively and does path
     * compression as well.
*/

struct Node* findSet(struct Node* node)
{
    struct Node* parent=node->parent;

    if(parent==node)
    {
        return node;
    }
    node->parent=findSet(node->parent);

    return node->parent;
};

void Union(int data1,int data2)
{
    struct Node* node1=Map[data1];
    struct Node* node2=Map[data2];

    struct Node* parent1=findSet(node1);
    struct Node* parent2=findSet(node2);

    if(parent1->data==parent2->data)
    {
        return;
    }

    //else whoever's rank is higher becomes parent of other

    if(parent1->Rank>=parent2->Rank)
    {
        //increment rank only if both sets have same rank
        parent1->Rank=(parent1->Rank==parent2->Rank)?parent1->Rank+1:parent1->Rank;
        parent2->parent=parent1;

    }else{

        parent1->parent=parent2;
    }



}

/* /**
     * Finds the representative of this set
     *
    public long findSet(long data){
        return findSet(map.get(data)).data;
    }*/
int findSetR(int data){
        return findSet(Map[data])->data;
}
int main()
{

       MakeSet(1);
       MakeSet(2);
       MakeSet(3);
       MakeSet(4);
       MakeSet(5);
       MakeSet(6);
       MakeSet(7);

       Union(1, 2);
       Union(2, 3);
       Union(4, 5);
       Union(6, 7);
       Union(5, 6);
       Union(3, 7);

       cout<<findSetR(1)<<endl;
       cout<<findSetR(2)<<endl;
       cout<<findSetR(3)<<endl;cout<<findSetR(4)<<endl;
       cout<<findSetR(5)<<endl;
       cout<<findSetR(6)<<endl;
       cout<<findSetR(7)<<endl;
       return 0;
}
