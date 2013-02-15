/******

Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1

*******/


#include <stdio.h>

#define MAX(a,b) ((a) > (b) ? a : b)
#define MIN(a,b) ((a) < (b) ? a : b)

int maxDistance(int arr[], int length){
	int *tempA = malloc(sizeof(int) * length);
	int *tempB = malloc(sizeof(int) * length);
	int i, j;
	int maxValueDif = -1;
	tempA[0] = arr[0];
	printf("%d \t", tempA[0] );
	for(i=1; i < length; i++){
		tempA[i] = MIN(arr[i], tempA[i-1]);
		printf("%d \t", tempA[i] );
	}
	printf("\n");
	tempB[length-1] = arr[length-1];
	for(i= length-2; i >= 0; i--){
		tempB[i] = MAX(arr[i], tempB[i+1]);
		printf("%d \t", tempB[i]);
	}
	printf("%d \t", tempB[length-1]);
	printf("\n");
	i=0; 
	j=0;
	int maxDist = -1;
	while(i< length && j <length){
		if(tempA[i] < tempB[j]){
			maxDist = MAX(maxDist, j-i);
			j++;
		}else{
			i++;
		}
	}
	return maxDist;
}

int main(){
	int input[] = {7, 6, 8, 4};
	int length = sizeof(input)/sizeof(input[0]);
	printf("length: %d\n", length);
	printf("distance: %d\n", maxDistance(input, length));
}