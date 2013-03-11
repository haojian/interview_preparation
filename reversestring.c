#include <stdio.h>

void reverse(char *str){
  int start = 0;
  int end = strlen(str)-1;
  //printf("%d", end);
  while(start < end){
    str[start] = str[start] ^ str[end];
    str[end] = str[start] ^ str[end];
    str[start] = str[start] ^ str[end];
    start++;
    end--;
  }
}

char *tmp = "abcde";

int main(){
  reverse(tmp);
  printf("%s", tmp);
  return 0;
}