package classical;

public class Fibnacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long curtime = System.currentTimeMillis();
		System.out.println(fibimprove(10));
		System.out.println("Time for matrix fib: " +  (System.currentTimeMillis()-curtime));
		curtime = System.currentTimeMillis();
		System.out.println(fibiter(1000000));
		System.out.println("Time for interative fib: " +  (System.currentTimeMillis()-curtime));
		curtime = System.currentTimeMillis();
		//System.out.println(fibrecur(100));
		//System.out.println("Time for recur fib: " +  (System.currentTimeMillis()-curtime));
		//curtime = System.currentTimeMillis();
	}

	public static long fibrecur(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibrecur(n-1) + fibrecur(n-2);
	}
	
	public static long fibiter(int n){
		if(n==0)
			return 0;
		long n_1 = 1;
		long n_2 = 0;
		long tmp = 0;
		while(n>1){
			tmp = n_1+n_2;
			n_2 = n_1;
			n_1 = tmp;
			n--;
		}
		return n_1;
	}
	
	public static long fibimprove(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibMatrix(n-1)[0][0];
	}
	
	//n would never be 0;
	//O(log n) space, O(log n) time
	public static long[][] fibMatrix(int n){
		long[][] matrix = {{1,1}, {1, 0}};
		if(n==1)
			return matrix;
		long[][] tmp = fibMatrix(n/2);
		if(n %2 == 1){
			return matrixMultiply(matrixMultiply(tmp, tmp), matrix);
		}else{
			return matrixMultiply(tmp, tmp);
		}
	}
	
	public static long[][] matrixMultiply(long[][] matrix1, long[][] matrix2){
		long[][] res = new long[2][2];
		res[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
		res[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
		res[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[0][1];
		res[1][1] = matrix1[1][0] * matrix2[0][1] + matrix2[1][1] * matrix2[1][1];
		return res;
	}
}
