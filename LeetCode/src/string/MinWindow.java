package string;

public class MinWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("acbbaca", "aba"));
	}
	
	
	//need map record the T
	//foundmap to track all the founded icons;
	//if(foundmap == needmap)
	//		return candidate
	//Continue expand the end index;
	//check if the start index could approach further too
	//	two case for approach:
	//		1. the character not exist in T
	//		2. the character in current range exceeds the needmap
	//Found the min range during search.
    public static String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int si=0;
    	int ei=0;
    	int[] needmap = new int[256];
    	int[] foundmap = new int[256];
    	for(int i=0; i<T.length(); i++){
    		needmap[T.charAt(i)]++;
    	}
    	char[] sa = S.toCharArray();
		int counter = 0;
		int[] minrange = new int[2];
		minrange[0]=0;
		minrange[1]=S.length()-1;
    	for(;ei<S.length(); ei++){
    		if(needmap[sa[ei]] == 0) continue;
    		foundmap[sa[ei]]++;
    		if(foundmap[sa[ei]] <= needmap[sa[ei]])
    			counter++;
    		//the window constraint is satisfied.
    		if(counter  == T.length()){
    			while(needmap[sa[si]] == 0 ||
    					foundmap[sa[si]]>needmap[sa[si]]){
    				if(foundmap[sa[si]]>needmap[sa[si]]){
        				foundmap[sa[si]]--;
    				}
    				si++;
    			}
    			if(ei-si <minrange[1]-minrange[0]){
    				minrange[0]=si;
    				minrange[1]=ei;
    			}
    		}
    	}
    	//for(int i=0; )
    	if(counter!=T.length())
    		return "";
    	return S.substring(minrange[0], minrange[1]+1);
    }

}
