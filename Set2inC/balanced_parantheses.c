/*Solution to Balanced Parantheses......
	1.Scan from Left to Right.
	2.If Opening Symbol add the bracket "'{','[','('" to a List.
	3.If Closing Symbol ,remove the Last Opening symbol in the List.
	4.If all is Ok then we will always end in an Empty list.

*/
#include<stdio.h>
#define MAX 50
char Stack[MAX];
int Top=-1;
void push(char c){
	if(Top==MAX-1){
		printf("Error : Stack OverFlow!!!\n");
		return;	
	}
	Stack[++Top]=c;
}

void pop(){
	if(Top==-1){
		printf("Stack Empty!!!");
		return;
	}
	Top--;//return Stack[Top];
}

int isEmpty(){
	if(Top==-1)
		return 1;
	else
		return 0;
}
char topOfStack(){
	return Stack[Top];
}
int ArePair(char opening,char closing){
	if(opening=='(' && closing ==')')
		return 1;
	else if(opening=='{' && closing =='}')
		return 1;
	else if(opening =='[' && closing ==']')
		return 1;
	else
		return 0;
}

int AreParanthesesBalanced(char *Exp,int len){
	int i=0;
	for(i=0;i<len;i++){
		if(Exp[i] == '(' ||Exp[i] == '{' ||Exp[i] == '['){
			push(Exp[i]);
		}else if(Exp[i] == ')' ||Exp[i] == '}' ||Exp[i] == ']'){
			if(isEmpty() || !ArePair(topOfStack(),Exp[i]))
				return 0;
			else
				pop();
		}
	}
	return isEmpty()?1:0;
}

int main(){
	char Exp[MAX];
	int len,true;
	printf("***Enter the Expression to Check for Balanced Parantheses***m \n");
	scanf("%s",Exp);	
	len =strlen(Exp);
	//printf("\n %d",len);
	true=AreParanthesesBalanced(Exp,len);
	if(true)
		printf("\nBalanced\n");
	else
		printf("\n Not Balanced\n");
	return 0;
}




