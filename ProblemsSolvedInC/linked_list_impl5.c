//Inserting at the end of the list and delete
#include<stdio.h>
struct node{
	int data;
	struct node* next;
};
struct node* head;

void delete(int n){
	struct node* temp=head;
if(n==1){
	head=temp->next;
	free(temp);return;
}
	int i;
	for(i=0;i<n-2;i++)
		temp=temp->next; //temp points to (n-1)th node
	struct node* temp1=temp->next; // nth node
	temp->next=temp1->next;//n+1 node
	free(temp1);
}
	
void insert(int data)  //insert at tail
{	
	
	struct node* new_node=(struct node*)malloc(sizeof(struct node));
	new_node->data=data;//or it can be assigned just after temp1 formation
	new_node->next=NULL;
	struct node* temp;
	if(head==NULL)
	{
		head=new_node;
		temp=new_node;
		return;	
	}
	temp=head;	
	while(temp->next!=NULL){
	temp=temp->next;
	}
	//temp->next=temp1;
	//temp1->data=data;//or it can be assigned just after temp1 formation
	//temp1->next=NULL;
	temp->next=new_node;
}
void print(){
		
	struct node* temp; // no need for malloc as we are not creating .just using temp node for traversing
	temp=head;
	printf("List is :");
	while(temp!=NULL){
		printf("%d",temp->data);
		temp=temp->next;
	}
	printf("\n");
}
void main()
{
	head=NULL;
	insert(2);
	insert(3);
	insert(4);
	delete(2);
	print();

}
	
