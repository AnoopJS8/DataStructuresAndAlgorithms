/*Binary Search Tree Iplementation*/
#include<stdio.h>

struct BstNode{
	int data;
	struct BstNode* left;
	struct BstNOde* right;
};
struct BstNode* getNewNode(int data){
	struct BstNode* newNode=(struct BstNode*)malloc(sizeof(struct BstNode));
	newNode->data=data;
	newNode->left=NULL;
	newNode->right=NULL;
	return newNode;
}
struct BstNode* insert(struct BstNode* root,int data){
	if(root==NULL)  //empty tree
	{
		root=getNewNode(data);
		//return root;
	}else if(data<=root->data)
	{	
		root=insert(root->left,data);
	}else
	{
		root=insert(root->right,data);
	}
		return root;
}
int main()
{
	struct BstNode* root; //pointer to root node
	root=NULL;
	root=insert(root,15);
	root=insert(root,10);
	root=insert(root,20);
}
