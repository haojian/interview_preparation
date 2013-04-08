#include <stdio.h>


/*

next(j) = maxinum(k), when 0<=k <j and p0p1p2p3p..pk = pj-kpj-k+1...pj (1)
          else -1, otherwise.
*/

void calnext(char* pattern, int *next){
  next[0];
  for(int i=0; i<pattern.length; i++){
    int k = next[i-1];
    while(pattern[k+1] != pattern[i] && k>=0){
      k = next[k];
    }

    if(pattern[k+1] == pattern[i]){
      next[i] = k+1;
    }
    else 
      next[i] = -1;
  }
}

int find(char *str1, char *str2){
  int n = strlen(str2);
  int *next = newe int[n];
  calnext(pat, next);
  char *p = str1;
  char *q = str2;

  int i=0;
  while(*p != '\0' && *(q+i)!= '\0'){
    if(*p == *(q+i)){
      p++;
      i++;
    }
    else{
      if(i==0)
        p++;
      else
        i=next[i-1]+1;
    }
  }
  if(*(q+i) == '\0')
    return p-str1-n;
  else return -1;
}

int main(){
  char* str1 = "test";
  char* str2 = "st";
  printf("%d", find(str1, str2));
  return -1;
}