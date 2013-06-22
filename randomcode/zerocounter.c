#include <stdio.h>

int main(){
	printf("%d \n", counter(5));
	printf("%d \n", counter(15));
	printf("%d \n", counter(10));
	printf("%d \n", counter(25));
}


int counter(int k){
	int counter = 0;
	int i;
	for(i=1; i<=k; i++){
		int tmp = i;
		while(tmp%5 == 0){
			tmp /= 5;
			counter++;
		}
	}
	return counter;
}