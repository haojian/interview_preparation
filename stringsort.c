/*******

Given two strings s1 and s2, s2 defines a desired ordering of its
characters. Return an anagram of s1 where s1's letters have been
reordered to match the order of s2. E.g. s1 = "abcdac", s2 ="bcade",
returns "bccaad"

********/

#include <stdio.h>

int map[256];

void output(char *str, int length){
	int i;
	for(i=0; i<length; i++){
		int index = (int)str[i];
		if(map[index] != 0){
			int j;
			for(j=0; j<map[index]; j++){
				printf("%c\n", str[i]);
			}
		}
	}
}

void getHash(char *str, int length){
	int i;
	for(i=0; i<length; i++){
		int index = (int)str[i];
		map[index]++;
	}
}


int main(){
	char *s1 = "abcdac";
	char *s2 = "bcade";
	
	getHash(s1, 6);
	output(s2, 4);
}