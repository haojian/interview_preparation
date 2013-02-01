/****
	to check if two strings are anagram.
***/

#include <stdio.h>

int map[256];
int ifAnagram(char *strA, char *strB, int lengthA, int lengthB){
	int i;
	if(lengthA != lengthB){
		return 0;
	}
	for(i=0; i<lengthA; i++){
		int index = (strA[i]);
		map[index]++;
	}
	for(i=0; i<lengthB; i++){
		int index = (strB[i]);
		map[index]--;
	}
	for(i=0; i<256; i++){
		if(map[i] != 0)
			return 0;
	}
	return 1;
}

int main(){
	char *string1 = "test";
	char *string2 = "estt";
	printf("%d\n", ifAnagram(string1, string2, 4, 4));
}