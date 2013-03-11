/*
Given a string, rotate it by 'k' position clockwise. 
So if the string is "abcdefg" and we need to rotate this by 2 positions, 
the output should be "fgabcde". 
The constraint is to do this in-place without using any additional memory. 
If you have read this in the book 'Programming Pearls' you know what I am talking about. 
So here is the simple code which does that.


http://crackprogramming.blogspot.com/2012/10/rotate-given-string-by-position.html

Complexity of the code
Assuming that length of string is 'N'.
1. Finding length of the string - O(N)
2. First reversal takes O(N/2) time
3. Second reversal takes O(k/2) time
4. Last reversal takes O(N-k/2) time
So total time taken is O(2N). Space requirement is almost constant.
This was definitely not the way I thought of when reading this problem. I will explain in my next blog post how I solved it.
Fun time - Break the code
1. str="abcdef", k=3. Output="defabc"
2. str="abcdef", k=0. Output="abcdef"
3. str="abcdef", k=6. Output="abcdef"
4. str="adcdef", k=13. Output="fabcde"
5. NULL and empty string.
6. String with one character.


*/


#include <stdio.h>

void reverseString(char* str, int si, int ei){
	while(si < ei){
		str[si] = str[si] ^ str[ei];
		str[ei] = str[si] ^ str[ei];
		str[si] = str[si] ^ str[ei];
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