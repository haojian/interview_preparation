package one;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"", "aabcccccaaa", "ab"};
		for(String str:input){
			System.out.println(compress(str));
		}
	}

	public static String compress(String input){
		if(input == null || input.length() == 0)
			return "";
		String output = "";
		int counter = 1;
		char lastchar = input.charAt(0);
		for(int i=1; i<input.length(); i++){
			if(lastchar == input.charAt(i)){
				counter++;
			}else{
				output += lastchar;
				output+= counter;
				counter=1;
				lastchar = input.charAt(i);
			}
		}
		if(counter != 0){
			output += lastchar;
			output += counter;
		}
		return output.length()>=input.length()?input:output;
	}
}
