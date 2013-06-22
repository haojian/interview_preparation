#include <stdio.h>

int main(){
	getNthMagicNum(1500);
	getNthMagNum(1500);
	return 0;
}

int getNthMagNum(int n){
	int v2=2, v3=3, v5=5;
	int c2=0, c3=0, c5=0;
	int min=1;
	int i;
	for(i=1; i<n; i++){
		if(v2<v3 && v2<v5){
			min = v2;
			c2++;
			v2*=2;
		}else if(v3<v2 && v3<v5){
			min = v3;
			c3++;
			v3*=3;
		}else{
			min = v5;
			c5++;
			v5*=5;
		}
	}
	printf("%d \t %d \t %d \t %d \n", min, c2, c3, c5);
	
	return min;
}


int getNthMagicNum(int n){
	int res[n];
	int p2=0, p3=0, p5=0;
	int i;
	res[0] = 1;
	int min = 0;
	for(i=1; i<n; i++){
		min = res[p2] * 2;
		if(min > res[p3] *3)
			min = res[p3] *3;
		if(min > res[p5] * 5)
			min = res[p5] * 5;
		res[i] = min;
		if(res[p2] * 2 <= min) p2++;
		if(res[p3] * 3 <= min) p3++;
		if(res[p5] * 5 <= min) p5++;
	}
	printf("%d \t %d \t %d \t %d \n", res[n-1], p2, p3, p5);
	return res[n-1];
}