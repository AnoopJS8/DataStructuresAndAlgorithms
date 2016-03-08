//insert a node at nth position
#include<stdio.h>
int count=0;
struct node{
	int data;
	struct node* next;
};
struct node* head;
void insert (int data,int n);
void print();
int main(){
	head=NULL;
	insert(2,1);
	insert(3,2);
	insert(4,3);
	insert(5,2);
	insert(6,4);
	insert(8,4);
	insert(9,4);
	insert(10,5);
	print();
return 0;
}

void insert(int data,int n)
{	count++;
	if(count<n)
		return;
	struct node* temp=(struct node*)malloc(sizeof(struct node));
	temp->data=data;
	//temp->next=head;
	if(n==1){
	temp->next=head;
	head=temp;
	return;
	}
	struct node* temp1=head;
	int i;	
	for(i=0;i<n-2;i++){
	temp1=temp1->next;
	}
	temp->next=temp1->next;
	temp1->next=temp;
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

	
