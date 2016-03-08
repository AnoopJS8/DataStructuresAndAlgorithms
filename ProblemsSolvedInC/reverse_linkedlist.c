#include<stdio.h>

struct node{
	int data;
	struct node* next;
};
struct node* head;
void reverse(){
	struct node *previous,*current,*next;
	current=head;
	previous=NULL;
	while(current!=NULL)
	{
		next=current->next;
		current->next=previous;
		previous=current;
		//next=current->next;
		current=next;
	}
	head=previous;
}

void insert (int data,int n);
void print();
int main(){
	head=NULL;
	insert(2,1);
	insert(3,2);
	insert(4,3);
	insert(9,4);
	insert(10,5);
	print();
	reverse();
	print();
return 0;
}

void insert(int data,int n)
{
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
		printf("%d ",temp->data);
		temp=temp->next;
	}
	printf("\n");
}





