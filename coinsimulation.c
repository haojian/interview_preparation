/*
	How to use a fair coin to simulate an unfair coin with probability p.
	
	similar question:
		Given a function which produces a random integer in the range 1 to 5, write a function which produces a random integer in the range 1 to 7.

		What is a simple solution?
		What is an effective solution to reduce memory usage or run on a slower CPU?
		
	Key solution: rejection sampling.
*/


int rand7(){
	int vals[5][5] = {
		{1, 1, 1, 2, 2},
		{2, 3, 3, 3, 4},
		{4, 4, 5, 5, 5},
		{6, 6, 6, 7, 7},
		{7, 0 ,0 ,0 ,0} 
	}
	
	int cIndex = rand5();
	int rIndex = rand5();
	while(vals[rIndex][cIndex] == 0){
		cIndex = rand5();
		rIndex = rand5();
	}
	return vals[rIndex][cIndex];
}

