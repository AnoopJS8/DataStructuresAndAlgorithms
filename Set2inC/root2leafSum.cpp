#include<iostream>
#include<stdio.h>
#include<vector>
using namespace std;

//int Arr[20];

vector<int> result;
struct Node {
	int data;
	struct Node *left;
	struct Node *right;
};

bool root2leafSum(Node *root,int sum,vector<int> *result){
    if(root == NULL)
        return false;
   // cout<<1;
    if(root->left==NULL && root->right==NULL){ //leaf node
      //  cout<<2;
        if(root->data==sum)
        {
            result->push_back(root->data);
//            cout<<endl<<root->data<<result.back();
  //          cout<<"Ho";
            return true;
        }else{
            return false;
        }

    }
   // cout<<2;
    if(root2leafSum(root->left,sum-root->data,result)){
        result->push_back(root->data);
       // cout<<"Ho";
        return true;
    }
    if(root2leafSum(root->right,sum-root->data,result)){
        result->push_back(root->data);
        return true;
    }
  //  cout<<3;
    return false;

}


// Function to Insert Node in a Binary Search Tree
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
int main() {
    Node* root = NULL;
	root = Insert(root,8); root = Insert(root,10);
	root = Insert(root,4); root = Insert(root,5);
	root = Insert(root,1); root = Insert(root,11);
	root= Insert(root,3);

   // for(int i=0;i<result.size();i++)
     //       cout<<result[i]<<" ";

   // cout<<result.size()<<endl;
	if(root2leafSum(root,16,&result))
    {
        int siz=result.size();
        for(int i=0;i<result.size();i++)
            cout<<result[siz-i-1]<<" ";
    }
    cout<<endl;
 //cout<<result.size()<<endl;
    return 0;

}
