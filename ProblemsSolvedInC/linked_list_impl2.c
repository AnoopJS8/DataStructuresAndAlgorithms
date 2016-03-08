//Inserting nodes at the beginning using head as a local variable instead of global
#include<stdio.h>
struct node {
	int data;
	struct node* next;
};
//struct node* head; //global variable can be accessed anywhere
struct node* insert(struct node* head,int x);
void print(struct node* head);
int main()
{
	struct node* head;
	head=NULL; // empty list
	int n,i,x;
	printf("Number of ELements to be inserted? \n");
	scanf("%d",&n);
	for(i=0;i<n;i++){
	printf("Enter the number");
	scanf("%d",&x);
	head=insert(head,x);
	}
	print(head);
	
	return 0;
}
struct node* insert(struct node* head,int x){
	struct node* temp =(struct node* )malloc(sizeof(struct node));//here we have to create a node so using malloc
	temp->data=x;//(*temp).data=x;	
	temp->next=head;
	head=temp;
	return head;
}

void print(struct node* head){
	//struct node* temp; // no need for malloc as we are not creating .just using temp node for traversing
	//temp=head;
	while(head!=NULL){
		printf("%d",head->data);
		head=head->next;
	}

}
