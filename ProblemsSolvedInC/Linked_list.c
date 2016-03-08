#include<stdio.h>
struct node{
	int data;
	struct node* next;
};
//struct node *Head;
//Head=0x12f4;

int main(){

	struct node* temp=(struct node* )malloc(sizeof(struct node));
	temp->data=8;
	temp->next=NULL;
	printf("%d \n",temp->data);
	printf("%d \n",(int)temp->next);
	//struct node* temp1=(struct node* )malloc(sizeof(struct node));
	temp=(struct node* )malloc(sizeof(struct node));	
	temp->data=18;
	temp->next=temp;
	printf("%d \n",temp->data);
	printf("%d is \n",(int)temp->next);
}
