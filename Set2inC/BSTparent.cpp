//Parent pointer bst
#include<iostream>
struct NodeP
{
   int data;
   NodeP *left;
   NodeP *right;
   NodeP *parent;
};


NodeP* Insert(NodeP *root,char data) {
	if(root == NULL) {
		root = new NodeP();
		root->data = data;
		root->left = root->right = NULL;
		root->parent=NULL;
	}
	else if(data <= root->data){
        root->left = Insert(root->left,data);
        root->left->parent=root;
	}
	else{
        root->right = Insert(root->right,data);
        root->right->parent=root;
	}
	return root;
}
struct NodeP* FindMin(struct NodeP* root) {
	if(root == NULL) return NULL;
	while(root->left != NULL)
		root = root->left;
	return root;
}

struct NodeP* Find(struct NodeP* root,int data) {
	if(root == NULL) return NULL;
	if(root->data==data)
        return root;
	else if(root->data>=data)
        Find(root->left,data);
    else if (root->data<data)
        Find(root->right,data);

	//return root;
}
int main()
{
    NodeP* root = NULL;
	root = Insert(root,8); root = Insert(root,10);
	root = Insert(root,4); root = Insert(root,5);
	root = Insert(root,1); root = Insert(root,11);
	root= Insert(root,3);

    NodeP *temp=Find(root,3);

    std::cout<<temp->parent->data<<"\n";

	return 0;
}
