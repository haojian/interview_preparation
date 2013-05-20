package basic;

public class CountBitsinInteger {

	/**
	 * 
+-------------------------------+
| 1 | 1 | 0 | 1 | 0 | 1 | 0 | 1 |  <- x
|  1 0  |  0 1  |  0 1  |  0 1  |  <- first time merge
|    0 0 1 1    |    0 0 1 0    |  <- second time merge
|        0 0 0 0 0 1 0 1        |  <- third time ( answer = 00000101 = 5)
+-------------------------------+
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=200;
		System.out.println(countbitv1(i));
		System.out.println(countbit(i));
	}
	
	public static int countbitv1(int i){
		int m1 = 0x55555555; //one zeros, one ones =>support 2 bit
		int m2 = 0x33333333; //two zeros, two ones	=>support 4 bit;
		int m3 = 0x0f0f0f0f; //four zeors, four ones =>support 8 bit;
		int m4 = 0x00ff00ff; //four zeors, four ones =>support 8 bit;

		i = (i&m1) + ((i>>1)&m1); 
		i = (i&m2) + ((i>>2)&m2); 
		i = (i&m3) + ((i>>4)&m3); 
		return i;
	}
	
	public static int countbit(int i){
		int counter =0;
		while(i>0){
			if(i%2==1)
				counter++;
			i/=2;
		}
		return counter;
	}

}
