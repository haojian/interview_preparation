package array;

public class SpaceReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Mr John Smith     ";
		char tmp[] = str.toCharArray();
		StringReplace(tmp, str.trim().length());
		System.out.print(tmp);
	}

	public static void StringReplace(char[] inputs, int originalLength){
		int spaceCounter = 0;
		for(int i = 0 ; i< originalLength; i++){
			if(inputs[i] == ' ')
				spaceCounter++;
		}
		int newlength = spaceCounter * 2 + originalLength;
		int tracker = originalLength-1;
		for(int i = newlength-1; i>=0; i--){
			if(inputs[tracker] != ' ')
				inputs[i] = inputs[tracker--];
			else{
				inputs[i--] = '0';
				inputs[i--] = '2';
				inputs[i] = '%';
				tracker--;
			}
		}
	}
	
}
