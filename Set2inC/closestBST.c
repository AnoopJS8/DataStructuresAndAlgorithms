#include<iostream>
#include<cstdio>
#include<math.h>
using namespace std;
#define MAX 10000

int diff=MAX;
int value;
struct node{
    int data;
    struct node* left;
    struct node* right;
};

struct node* root=NULL;
//Utility FUnctions

struct node* createNode(int data){
    struct node* newNode=(struct node*)malloc(sizeof(struct node));
    newNode->data=data;
    newNode->left=NULL;
    newNode->right=NULL;

    return newNode;
};
void insertNode(struct node** root,int data){

    if(*root==NULL){
        *root=createNode(data);
        return;// root;*/

    }
    if(*root->data>data){
        insertNode(*root->left,data);
    }else if(*root->data<=data){
        insertNode(root->right,data);
    }

}

void inorderTraversal(struct node* root){
    if (root==NULL)
        return;
    inorderTraversal(root->left);
    cout<<root->data;
    inorderTraversal(root->right);

}

int closestNode(struct node* root,int val)
{
    if(root==NULL){
        return
    }
    if(val<root->data){
        closestNode(root->left);
    }else{
        closestNode(root->right);
    }
    int dif=abs(val-root->data);
    if(diff>dif)
     {
        diff=dif;
        value=root->data;
     }


}

int main(){

    struct node* root=NULL;
    insertNode(&root,2);
    insertNode(&root,1);
    insertNode(&root,7);
    insertNode(&root,6);
    insertNode(&root,8);
    inorderTraversal(root);
}
