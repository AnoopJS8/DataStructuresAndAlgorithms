//Inserting nodes at the beginning
#include<stdio.h>
struct node {
	int data;
	struct node* next;
};
struct node* head; //global variable can be accessed anywhere
void insert(int x);
void print();
int main()
{
	head=NULL; // empty list
	int n,i,x;
	printf("Number of ELements to be inserted? \n");
	scanf("%d",&n);
	for(i=0;i<n;i++){
	printf("Enter the number");
	scanf("%d",&x);
	insert(x);
	print();
	}
	return 0;
}
void insert(int x){
	struct node* temp =(struct node* )malloc(sizeof(struct node));//here we have to create a node so using malloc
	temp->data=x;//(*temp).data=x;	
	temp->next=head;
	head=temp;
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
