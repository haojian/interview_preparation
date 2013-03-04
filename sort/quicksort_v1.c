#include <stdio.h>

void exchange(int *a, int *b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

int partition(int A[], int si, int ei){
	int j;
	int x = A[ei];
	int i = si-1;
	for(j=si; j<ei; j++){
		if(A[j] <= x){
			i++;
			exchange(&A[j], &A[i]);
		}
	}
	exchange(&A[i+1], &A[ei]);
	return i+1;
}

void quicksort(int A[], int si,  int ei){
	if(si<ei)
	{
		int p = partition(A, si, ei);
		quicksort(A, si, p-1);
		quicksort(A, p, ei);
	}
}

int main(){
	int tmp[] = {2,3 ,4, 5,1, 7,8};
	quicksort(tmp, 0, 6);
	int i;
	for(i =0; i< 7; i++){
		printf("%d", tmp[i]);
	} 
}