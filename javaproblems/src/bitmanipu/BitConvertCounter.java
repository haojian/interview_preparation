package bitmanipu;

public class BitConvertCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerConvertCounter(31,14);
		IntegerConvertCounter(3,2);
		IntegerConvertCounter(0,1);
	}

	public static int IntegerConvertCounter(int a, int b){
		int counter =0;
		int tmp = a^b;
		while(tmp>0){
			if(tmp % 2 == 1){
				counter++;	
			}
				tmp/=2;
		}
		System.out.println(counter);
		return counter;
	}
}
