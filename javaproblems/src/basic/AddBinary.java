package basic;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("1111", "1111"));
	}
	
    public static String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String res = "";
        int ai = a.length()-1;
        int bi = b.length() -1;
        int update = 0;
        while(ai >= 0 || bi>=0 || update != 0){
        	int digita = 0, digitb=0;
        	digita = ai<0? 0:a.charAt(ai)-'0';
        	digitb = bi<0? 0:b.charAt(bi)-'0';
        	int resdigit = digita+digitb+update;
        	update = 0;
        	if(resdigit %2 == 0){
        		update = resdigit/2;
        		resdigit = 0;
        	}else{
        		update = resdigit/2;
        		resdigit = 1;
        	}
        	res = resdigit+ res;
        	ai--;
        	bi--;
        }

        return res;
    }

}
