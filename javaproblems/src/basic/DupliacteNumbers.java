package basic;

public class DupliacteNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 2, 2,1,2, 3, 4, 5};
		Outputduplicate(A);
	}

	public static void Outputduplicate(int A[]){
		int record[] = new int[100];
		for(int tmp: A){
			if(record[tmp] != 0)
			{
				System.out.println("TIMES: " + (record[tmp]+1) + "\t Value" + tmp);
			}
			record[tmp]++;
		}
	}
}
