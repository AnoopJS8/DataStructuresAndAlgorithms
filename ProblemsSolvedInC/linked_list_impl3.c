//Inserting nodes at the beginning using head as a local variable instead of global and passing pointer var head as a ref using pointer to pointer concept.
#include<stdio.h>
struct node {
	int data;
	struct node* next;
};
//struct node* head; //global variable can be accessed anywhere
void insert(struct node** pointer2head,int x);
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
	insert(&head,x);
	}
	print(head);
	
	return 0;
}
void insert(struct node** pointer2head,int x){
	struct node* temp =(struct node* )malloc(sizeof(struct node));//here we have to create a node so using malloc
	temp->data=x;//(*temp).data=x;	
	temp->next=*pointer2head;
	*pointer2head=temp;
	//return head;
}

void print(struct node* head){
	//struct node* temp; // no need for malloc as we are not creating .just using temp node for traversing
	//temp=head;
	while(head!=NULL){
		printf("%d",head->data);
		head=head->next;
	}

}
