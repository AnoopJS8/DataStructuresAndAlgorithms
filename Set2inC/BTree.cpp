#include<iostream>
using namespace std;

class BTreeNode
{
    int *keys; //An Array of keys
    int t;     //Minimum degree (defines the range for the number of keys)
    BTreeNode **C; // An array of child pointers
    int n; //Current number of keys
    bool leaf; //It is true if the node is leaf ,otherwise false;

public:
    BTreeNode(int _t,bool _leaf); //Constructor


    //A function to traverse  all nodes in a subtree rooted with this node.
    void traverse();
    //A function to search a key in the subtree rooted at this node .
    BTreeNode *search(int k); // return NULL if k is not present

    friend class BTree; //Making the Btree a friend class such that it can access the private members of this class in BTree functions
};

//A Btree
class BTree
{
    BTreeNode *root; //Pointer to root node
    int t;//Minimum degree

public:
    //Constructor (Initializes tree as empty)
    BTree(int _t)
    {
        root=NULL;
        t=_t;
    }
    //function to traverse the tree
    void traverse()
    {
        if(root!=NULL)
            root->traverse();
    }

    //function to search a key in this tree

    BTreeNode* search(int k)
    {
        return (root==NULL)?NULL:root->search(k);
    }
};

//Constructor for BTreeNode class
BTreeNode::BTreeNode(int _t,bool _leaf)
{
    // Copy the given minimum degree and leaf property
    t=_t;
    leaf=_leaf;

    //Allocate memory for maximum no of possible keys and child pointers
    keys=new int[2*t-1];
    C= new (BTreeNode*)[2*t];

    //Initialize the no of keys to be zero
    n=0;
}
//Function to traverse all nodes in a subtree rooted with this node

void BTreeNode::traverse()
{
    //There are n keys and n+1 children ,traverse through n keys and first n children

    int i;
    for(i=0;i<n;i++)
    {
        //If this node is not the leaf ,then before printing the key[i] ,
        //traverse the subtree rooted with child C[i].
        if(leaf==false)
            C[i]->traverse();
    }
}

//Function to search key k in subtree rooted with this node

BTreeNode *BTreeNode::search(int k)
{

    //Find the first key greater than k
    int i=0;
    while(i<n && k>keys[i])
        i++;
    //If the key founded is equal to k ,return this node
    if(keys[i]==k)
        return this;

    //if key is not found here and this is a leaf node
    if(leaf==true)
        return NULL;
    //Otherwise go to the appropriate child

    return C[i]->search(k);
}
