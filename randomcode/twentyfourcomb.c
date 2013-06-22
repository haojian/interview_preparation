#include <stdio.h>

void swap(int input[], int si, int ei){
	int tmp = input[si];
	input[si] = input[ei];
	input[ei] = tmp;
}

void combRecur(int input[], char sym[], int si, int curval, int target){
	if(si == 4 && curval == target){
		printf("((%d %c %d) %c %d) %c %d = 24 \n", input[0], sym[0], input[1], sym[1], input[2], sym[2], input[3]);
		return;
	}
	if(si >=4)
		return;
	int i;
	for(i = si; i<4; i++){
		swap(input, si, i);
		
		sym[si-1] = '+';
		combRecur(input, sym, si+1, curval+input[si], 24);
		sym[si-1] = '-';
		combRecur(input, sym, si+1, curval-input[si], 24);
		sym[si-1] = '*';
		combRecur(input, sym, si+1, curval*input[si], 24);
		sym[si-1] = '/';
		combRecur(input, sym, si+1, curval/input[si], 24);
		
		swap(input, si, i);
	}
}

int main(){
	int input[] = {4, 5, 2, 2};
	char sym[3]; 
	int i;
	for(i=0; i<4; i++){
		swap(input, 0, i);
		combRecur(input, sym, 1, input[0], 24);
		swap(input, 0, i);
	}
}