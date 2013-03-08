/*
Given a string, rotate it by 'k' position clockwise. 
So if the string is "abcdefg" and we need to rotate this by 2 positions, 
the output should be "fgabcde". 
The constraint is to do this in-place without using any additional memory. 
If you have read this in the book 'Programming Pearls' you know what I am talking about. 
So here is the simple code which does that.


http://crackprogramming.blogspot.com/2012/10/rotate-given-string-by-position.html
*/


#include <stdio.h>

void reverseString(char* str, int si, int ei){
	while(si < ei){
		str[si] = str[si] ^ str[ei];
		str[back] = str[si] ^ str[ei];
		str[front] = str[si] ^ str[ei];
		++si;
		--back;
	}
	return;
}

void rotateString(char *str, int k){
	if(!str || !*str)
		return;
	int len = strlen(str);
	/*Rotating a string by it's length is string itself.*/
	k %= len;
	
	reverseString(str, 0, len-1);
	reverseString(str, 0, k-1);
	reverseString(str, k, len-1);
}

int main(){
	
}