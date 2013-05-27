package combinatorics;

import java.util.ArrayList;

public class RestoreIP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010"));
	}
	
    public static ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<String> res = new ArrayList<String>();
    	restoreRecur(s, 0, new ArrayList<String>(), res);
    	return res;
    }
	
    public static void restoreRecur(String s, int si, ArrayList<String> curIP, ArrayList<String> res){
        if(si == s.length() && curIP.size() == 4){
            String out = "";
            for(String str:curIP)
            {
                out+=str+".";
            }
            res.add(out.substring(0, out.length()-1));
            return;
        }else if(curIP.size() == 4){
            return;
        }
        else{
            for(int offset=1; offset<=3; offset++){
            	if(si+offset > s.length())
            		continue;
                String tmp = s.substring(si,si+offset);
                
                int value = Integer.valueOf(tmp);
                if(tmp.startsWith("0") && tmp.length()>1)
                	continue;
                curIP.add(tmp);
                if(value >=0 && value <=255)
                    restoreRecur(s, si+offset, curIP, res);
                curIP.remove(curIP.size()-1);
            }
        }
    }

}
