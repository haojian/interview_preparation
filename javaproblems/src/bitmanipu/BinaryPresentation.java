package bitmanipu;

public class BinaryPresentation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		binarypresentation(0.5);
		binarypresentation(0.25);
		binarypresentation(0.72);

	}
	
	public static char[] binarypresentation(double input){
		char[] res = new char[32];
		int index = 0;
		res[index++] = '0';
		res[index++] = '.';
		while(input != 0){
			if(index >= 32){
				System.out.println("ERROR");
				return null;
			}

			if(input * 2 >=1){
				res[index++] = '1';
				input = input *2-1;
			}else{
				res[index++] = '0';
				input = input *2;
			}
		}	
		System.out.println(res);
		return res;
	}

}
