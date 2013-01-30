#include <stdio.h>
#include <stdlib.h>

typedef struct _node{
	int data;
	struct _node *next;
}Node;

Node *initLinkedList(int *array, int length){
	Node *curNode = NULL;
	Node *res = NULL;
	if(length != 0 ){
		res = (Node *)malloc(sizeof(Node));
		res->data = array[0];
		curNode = res;
	}
	int i;
	for(i=1; i< length; i++){
		curNode->next = (Node *)malloc(sizeof(Node));
		curNode = curNode->next;
		curNode->data = array[i];
	}
	return res;
}

Node *MergeLists(Node *listA, Node *listB){
	Node *res = NULL;
	Node **resHead = &res;
	
	Node *curNode1 = listA;
	Node *curNode2 = listB;
	while(curNode1 && curNode2){
		if(curNode1->data > curNode2->data){
			*resHead = (Node *)malloc(sizeof(Node));
			(*resHead)->data = curNode1->data;
			curNode1 = curNode1->next;
		}else{
			*resHead = (Node *)malloc(sizeof(Node));
			(*resHead)->data = curNode2->data;
			curNode2 = curNode2->next;
		}
		resHead = &((*resHead)->next);
	}
	*resHead = curNode1 ? curNode1 : curNode2;

	return res;
}

void PrintList(Node *list){	
	while(list){
		printf("%d\t", list->data);
		list = list->next;
	}
	printf("\n");
}

int main(){
	int input1[] = {9, 5, 4, 1};
	int input2[] = {8, 6, 2, 0};
	int length1 = sizeof(input1)/sizeof(input1[0]);
	int length2 = sizeof(input2)/sizeof(input2[0]);
	Node *list1 = initLinkedList(input1, length1);
	Node *list2 = initLinkedList(input2, length2);
	
	PrintList(list1);
	PrintList(list2);
	PrintList(MergeLists(list1, list2));
	return 0;
}