#include<iostream>

struct Node {
	char data;
	Node *left;
	Node *right;
};

bool isSameTree(Node *rootA,Node *rootB)
{
    if(rootA==NULL && rootB==NULL)
        return true;
    else if(rootA==NULL || rootB==NULL)
        return false;
    else{
        return rootA->data==rootB->data && isSameTree(rootA->left,rootB->left) && isSameTree(rootA->right,rootB->right);
    }

}
Node* Insert(Node *root,int data) {
	if(root == NULL) {
		root = new Node();
		root->data = data;
		root->left = root->right = NULL;
	}
	else if(data <= root->data)
		root->left = Insert(root->left,data);
	else
		root->right = Insert(root->right,data);
	return root;
}

int main()
{
    Node* root1 = NULL;
	root1 = Insert(root1,8); root1 = Insert(root1,10);
	root1 = Insert(root1,4); root1 = Insert(root1,5);
	root1 = Insert(root1,1); root1 = Insert(root1,11);
	root1= Insert(root1,3);

	Node* root2 = NULL;
	root2 = Insert(root2,8); root2 = Insert(root2,10);
	root2 = Insert(root2,4); root2 = Insert(root2,5);
	root2 = Insert(root2,1); root2 = Insert(root2,11);
	root2= Insert(root2,3);


    std::cout<<isSameTree(root1,root2);
    return 0;
}


