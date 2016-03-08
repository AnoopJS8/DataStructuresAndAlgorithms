//Inserting nodes at the beginning
#include<stdio.h>
struct node {
	int data;
	struct node* next;
};
struct node* head; //global variable can be accessed anywhere
void insert(int x);
void print();
void alternate();
void rearrange();
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
	print();}
	printf("In Alternate order\n");
	alternate();
	//rearrange();
	print();
	//}
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

void alternate(){
	struct node* temp=head;
	//struct node* temp1=head;
	struct node* temp1;
	struct node* temp2=temp->next;
	temp1=temp2;
	//struct node* temp2;
	//temp1=head->next;
	//temp1->next=NULL;
	while(temp->next!=NULL && temp->next->next!=NULL){
		temp->next=temp->next->next;
		                                                                   //temp1->next=temp->next->next;		
		temp=temp->next;
		//temp1=temp->next;
		//temp->next=temp1;
		         //temp1->next=temp->next;
		//temp1=temp1->next;
		  temp2->next=temp->next;
			if(temp2->next!=NULL)temp2=temp2->next;
		//temp1=temp1->next;
		//temp2=temp1;
	}
	temp->next=temp1;
	//temp1->next=NULL;
	temp2->next=NULL;	
//temp1=NULL;
}

void rearrange(){
	struct node* odd=head;
	if (odd == NULL || odd->next == NULL || odd->next->next == NULL)
        return;
	struct node *even ;//= odd->next;
	struct node *even1=odd->next;
	even=even1;
	odd->next = odd->next->next;
	odd = odd->next; 
	even->next=NULL;
	while (odd && odd->next)
    {
       // Store the next node in odd list 
       struct node *temp = odd->next->next;
 
       // Link the next even node at the end of even list
      // odd->next->next = even;
	even1->next=odd->next;//->next;
	//even=odd->next->next;       
	even1 = even1->next;//odd->next;
 
       // Remove the even node from middle
       odd->next = temp;
 
       // Move odd to the next odd node
       if (temp != NULL)
         odd = temp;
    }
   even1->next=NULL;
    // Append the even list at the end of odd list
    odd->next = even;


}
