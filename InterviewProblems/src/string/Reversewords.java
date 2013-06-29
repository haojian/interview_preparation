package string;

public class Reversewords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWord("I am a student."));
	}
	
	
	public static String reverseWord(String in){
		in = reverseStr(in);
		String[] res = in.split(" ");
		for(int i=0; i<res.length; i++){
			res[i] = reverseStr(res[i]);
		}
		String resStr = "";
		for(String str:res)
			resStr += str + " ";
		return resStr;
	}
	
	public static String reverseStr(String in){
		char[] arr = in.toCharArray();
		int si=0;
		int ei = in.length()-1;
		while(si<ei){
			char tmp = arr[si];
			arr[si] = arr[ei];
			arr[ei] = tmp;
			si++;
			ei--;
		}
		return new String(arr);
	}

}
