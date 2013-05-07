package string;

public class DistinctSquence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
	
    public static int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[1];
        res[0] = 0;
        count(S, T, 0, 0, res);
        return res[0];
    }
    
    public static void count(String S, String T, int si, int ti, int[] res){
    	if(ti == T.length()){
    		res[0]++;
    	}else{
    		if(S.length()-si < T.length()-ti){
    			return;
    		}
    		else if(S.charAt(si) == T.charAt(ti)){
    			//match or not match
    			count(S, T, si+1, ti+1, res);
    			count(S, T, si+1, ti, res);
    		}else{
    			count(S, T, si+1, ti, res);
    		}
    	}
    }

}
