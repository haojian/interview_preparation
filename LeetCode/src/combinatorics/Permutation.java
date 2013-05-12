package combinatorics;

import java.util.ArrayList;

public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation tmp = new Permutation();
		String[] L = {"a","b","b"};
		String s = "abaababbaba";
		System.out.println(tmp.getPermu(L));
		System.out.println(tmp.findSubstring(s, L));
	}
	
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> combo = getPermu(L);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(String tmp:combo){
        	int i = S.indexOf(tmp);
            while(i != -1){
            	res.add(i);
            	i = S.indexOf(tmp, i+1);
            }
        }
        return res;
    }
	
    public ArrayList<String> getPermu(String[] L){
        ArrayList<String> res = new  ArrayList<String>();
        generatePermutation(L, 0, "", res);
        return res;
   }
   
   public void generatePermutation(String[] L, int depth, String cur, ArrayList<String> res){
       if(depth == L.length)
           res.add(cur);
       else{
           for(int i=depth; i<L.length; i++){
        	   if(ifSwap(L, depth, i)){
        		   swap(L, i, depth);
        		   generatePermutation(L, depth+1, cur+L[depth], res);
        		   swap(L, i, depth);
               }
           }
       }
   }
   
   public static void swap(String[] L, int si, int ti){
	   String tmp = L[si];
	   L[si] = L[ti];
	   L[ti] = tmp;
   }
   
   public static boolean ifSwap(String[] L, int si, int ei){
	   for(int i=si; i<ei; i++){
		   if(L[i].equals(L[ei]))
			   return false;
	   }
	   return true;
   }

}
