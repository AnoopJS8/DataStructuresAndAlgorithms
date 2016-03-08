#include<stdio.h>
struct node{
	int data;
	struct node* prev;
	struct node* next;
};
struct node* head;
struct node* getNewNode(int x){
	struct node* newNode=(struct node*)malloc(sizeof(struct node));
	newNode->data=x;
	newNode->prev=NULL;
	newNode->next=NULL;
	return newNode;
}
void insertAtHead(int x){
	
	struct node* newNode=getNewNode(x);
	struct node* temp1;	
	if(head==NULL){
		head=newNode;
		return;
	}
	head->prev=newNode;
	newNode->next=head;
	//newNode->prev=NULL;  not required as already we are making it NULL while node creation.
	head=newNode;
	

}
void insertAtTail(int x){
	struct node* newNode=getNewNode(x);
	struct node* temp=head;
	if(temp==NULL){
		head=newNode;
		return;
	}
	while(temp->next!=NULL){		//going to the last node
		temp=temp->next;
	}
	newNode->prev=temp;
	temp->next=newNode;
	//newNode->next=NULL;	 no need as i am already making the node with links equal to NULL
	
}
void print(){
	struct node* temp=head;
	while(temp!=NULL){
	printf("%d",temp->data);
	temp=temp->next;
	}
	printf("\n");
}
void reversePrint(){
	struct node* temp=head;
	if(temp==NULL) return; //empty list
	//going to last node
	while(temp->next!=NULL)   ///going to the second last element
		temp=temp->next;
	printf("Reverse :\t");
	while(temp!=NULL){
		printf("%d",temp->data);
		temp=temp->prev;
}
		printf("\n");
}

int main()
{
	head=NULL;
	insertAtTail(2);insertAtTail(3);insertAtTail(4);print();reversePrint();	
}
