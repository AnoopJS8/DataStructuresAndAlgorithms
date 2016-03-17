#include<stdio.h>
struct node{
	int data;
	struct node* next;
}; 
struct node* Head=NULL;
//struct node* Tail=NULL;
void insertAtHead(int x);
void insertAtTail(int x);
void printList();
void removeNode(int key);
int main(){
	insertAtHead(2);
	insertAtHead(4);
	insertAtHead(8);
	insertAtHead(34);
	insertAtHead(88);
	printList();
	//insertAtTail(2);
	//insertAtTail(4);
	//insertAtTail(8);
	//insertAtTail(34);
	//insertAtTail(88);
//	printList();
	removeNode(88);
	printList();
	return 0;
}

void insertAtHead(int x){
	if(Head==NULL){
		struct node* temp=(struct node*)malloc(sizeof(struct node));
		Head=temp;
		temp->data=x;
		temp->next=Head;
	}else{
		struct node* temp=(struct node*)malloc(sizeof(struct node));
		struct node* last=Head;
		while(last->next!=Head)
			last=last->next;
		last->next=temp;
		temp->data=x;
		temp->next=Head;
		Head=temp;
	}

}

void insertAtTail(int x){
	if(Head==NULL){
		struct node* temp=(struct node*)malloc(sizeof(struct node));
		Head=temp;
		temp->data=x;
		temp->next=Head;
	}else{
		struct node* temp=(struct node*)malloc(sizeof(struct node));
		struct node* temp1=Head;
		while(temp1->next!=Head){  // This brings us to the last node where the temp->next is Head.
			temp1=temp1->next;
		}		
			temp1->next=temp;//temp1->next->next=temp;
			temp->data=x;
			temp->next=Head;
		}

}
		

void printList(){
     
    struct node* temp = Head;
    int count = 1;
    printf("Printing the linked list\n");
    
    if ( Head!=NULL){
       printf("data number %d is = %d\n",count++,temp->data);
       temp=temp->next;
    }
    while (temp !=Head){
          
        printf("data number %d is = %d\n",count++,temp->data);
        temp=temp->next;       
    }
    //printf("data number %d is = %d\n",count++,temp->next->data);
    printf("\n");     
}

void removeNode(int key){
	/*if(Head->data == key){
		struct node* temp=Head;
		Head=Head->next;
		free(temp);
	}*/if(Head->data == key){ struct node* temp1=Head;
		struct node* temp=Head;
		while(temp->next!=Head)
			temp=temp->next;
		Head=Head->next;
		temp->next=Head;
		free(temp1);
	}	
	else{
		struct node* temp = Head;
         while (temp->next->data !=key)
             temp = temp->next;
             
         struct node* temp2 = temp->next;
         temp->next = temp2->next;
         free(temp2);     

}
}
