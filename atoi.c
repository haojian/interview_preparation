#include <stdio.h>

int new_atoi(char* pStr){
	int resVal = 0;
	int sign = 1;
	if(*pStr == '-'){
		sign = -1;
		pStr++;
	}
	if(pStr){
		while(*pStr && *pStr <= '9' && *pStr >= '0'){
			resVal = resVal *10 + (*pStr - '0');
			pStr++;
		}
	}
	return resVal * sign;
}

int main(){
	printf("%d\t%d\n", atoi("12345"), new_atoi("12345"));
	printf("%d\t%d\n", atoi("12345a"), new_atoi("12345a"));
	printf("%d\t%d\n", atoi("-12345a"), new_atoi("-12345a"));
	printf("%d\t%d\n", atoi("--12345a"), new_atoi("--12345a"));
	printf("%d\t%d\n", atoi("-125a22"), new_atoi("-125a22"));

	return 0;
}