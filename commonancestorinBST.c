/*****
Given the values of two nodes in a *binary search tree*, 
write a c program to find the lowest common ancestor. 
You may assume that both values already exist in the tree.
******/

#include <stdio.h>


typedef struct _node{
	int data;
	struct node* left;
	struct node* right;
}node;

node* newNode(int val){
	node* tmp = (node *)malloc(sizeof(node));
	tmp->left = null;
	tmp->right = null;
	tmp->data = data;
	return tmp;
}

int leastCommonAncestor(node* root, int n1, int n2){
	if(root == NULL || root->data == n1 || root->data == n2)
		return -1;
	if((root->right != NULL && (root->right->data == n1 || root->right->data == n2)){
		return root->data;
	}
	if((root->left != NULL && (root->left->data == n1 || root->right->data == n2)){
		return root->data;
	}
	if(root->data > n1 && root->data < n2){
		return root->data;
	}
	if(root->data >n1 && root->data > n2){
		return leastCommonAncestor(root->left, n1, n2);
	}
	if(root->data <n1 && root->data < n2 ){
		return leastCommonAncestor(root->right, n1, n2);
	}
}

int main(){
	return 0;
}