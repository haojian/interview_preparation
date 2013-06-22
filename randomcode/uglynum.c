#include <stdio.h>


long min(long next_2, long next_3, long next_5){
	long tmp = next_2 <next_3 ? next_2:next_3;
	return tmp<next_5?tmp:next_5;
}

long uglynum(int k){
	long dp[k];
	dp[0] = 1;
	int i2=0, i3=0, i5= 0;
	long curnum;
	long next_multi_2 = dp[i2] *2;
	long next_multi_3 = dp[i3] *3;
	long next_multi_5 = dp[i5] *5;
	int i;
	for(i=1; i<k; i++){
		int tmp = min(next_multi_2, next_multi_3, next_multi_5);
		dp[i] = tmp;
		if(tmp == next_multi_2){
			i2++;
			next_multi_2 = dp[i2]*2;
		}
		if(tmp == next_multi_3){
			i3++;
			next_multi_3 = dp[i3]*3;
		}
		if(tmp == next_multi_5){
			i5++;
			next_multi_5 = dp[i5] *5;
		}
	}
	return dp[k-1];
}


int main(){
	printf("%ld \n", uglynum(1500));
	return 0;
}

