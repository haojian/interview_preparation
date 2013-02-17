#include <stdio.h>


int partition(int A[], int si, int ei){
	int x = A[ei];
	int i = (si-1);
	int j;
	for(j=si; j<=ei-1;j++){
		if(A[j] <= x){
			i++;
			exchange(&A[i], &A[j]);
		}
	}
	exchange(&A[i+1], )
}

void quicksort(int A[], int si, int ei)
{
	int pi = -1;
	if(si<ei){
		pi = partition(A, si, ei);
		quicksort(A, si, pi-1);
		quicksort(A, pi+1, ei);
	}
}

int main(){
	
}