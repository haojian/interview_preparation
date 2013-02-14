#include <stdio.h>
#include <stdlib.h>

int shufflist[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
int currentMaxIndex = -1;

int getRandomNumber(currentMaxIndex){
	int curIndex = rand()%(currentMaxIndex+1);
	int tmp = shufflist[curIndex];
	shufflist[curIndex] = shufflist[currentMaxIndex];
	shufflist[currentMaxIndex] = tmp;
	return tmp;
}

int main(){
	int length = sizeof(shufflist)/sizeof(shufflist[0]);
	printf("array length: %d\n", length);
	
	currentMaxIndex = length-1;
	while(currentMaxIndex >= 0){
		printf("%d\t", getRandomNumber(currentMaxIndex));
		currentMaxIndex--;
	}
	printf("\n");
}