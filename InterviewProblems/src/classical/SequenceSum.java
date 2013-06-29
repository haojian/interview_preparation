package classical;

public class SequenceSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(100));
	}

	
	public static int sum(int n){
		return n==0?0:sum(n-1)+n;
	}
}
