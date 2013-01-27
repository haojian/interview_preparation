/*
Given a huge sorted integer array A, and there are huge duplicates in the 
array. Given an integer T, inert T to the array, if T already exisit, insert
it at the end of duplicates. 

Find the insert point. The signature:

int FindInsertionPosition(int A[], int size, int T);

For example:

A[15] = {2,5,7,8,8,8,8,8,8,8,8,8,8,8,9}
If T == 6, return 2;
If T == 8' return 14
*/

#include "stdio.h"

int FindInsertionPosition(int A[], int size, int T){
	
}

int main(){
	int A[15] = {2,5,7,8,8,8,8,8,8,8,8,8,8,8,9};
	int length = sizeof(A)/sizeof(int);
	
	printf("length is  %d \n", length);
	
	//printf(FindInsertionPosition(A, length, 6) + "\n");
	//printf(FindInsertionPosition(A, length, 8) + "\n");
	return 0;
}