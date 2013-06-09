package basic;

import java.util.ArrayList;

public class ValidNumber {

	/**
	 * 
	 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
"1.3e2"	=> true;
+2e-3 => true;


Grammer:
	Number => Decimal | Scientific;
	Number => '+' Expr | '-' Expr | Expr;
	Expr   => Digits | Decimal | Scientific;
	Digits => [1-9] Digits | empty;
	Decimal=> Digits '.' Digits;
	Scientific => Decimal 'e' Digits;

	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(s==null)
    		return false;
        s = s.trim();
    	boolean ifCouldDot = true;
    	boolean ifCoulde = true;
    	boolean ifCouldsign = true;
    	boolean neednum = true;
    	for(int i=0; i<s.length(); i++){
    		if(s.charAt(i) >= '0' && s.charAt(i) <='9'){
    			ifCouldsign = false;
    			neednum = false;
    			continue;
    		}
    		else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
    			if(ifCouldsign){
    				ifCouldsign = false;
    				//neednum = true;
    			}else
    				return false;
    		}
    		else if(s.charAt(i) == '.'){

    			if(ifCouldDot){
    				ifCouldDot = false;
    				ifCouldsign = false;
    			}else{
    				return false;
    			}
    			//neednum = true;
    		}
    		else if(s.charAt(i) == 'e'){
    			if(neednum)
    				return false;
    			if(ifCoulde)
    				ifCoulde = false;
    			else
    				return false;
    			neednum = true;
    			ifCouldDot = false;
    			ifCouldsign = true;
    		}else
    			return false;
    	}
    	if(neednum)
    		return false;
    	return true;
    }
    
    public boolean getTokens(String s, ArrayList<Token> res){
    	boolean inNum = false;
    	String str = "";
    	for(int i=0; i<s.length(); i++){
    		if(s.charAt(i)>='0' && s.charAt(i)<='9'){
    			str+=s.charAt(i);
    			inNum = true;
    		}else{
    			if(inNum == true){
    				Token newToken = new Token(0, str);
    				str ="";
    				res.add(newToken);
    			}
    			if(s.charAt(i)=='+' || s.charAt(i)=='-'){
    				Token newToken = new Token(3, s.substring(i, i+1));
    				res.add(newToken);
    			}else if(s.charAt(i) =='.'){
    				Token newToken = new Token(1, s.substring(i, i+1));
    				res.add(newToken);
    			}else if(s.charAt(i) =='e' || s.charAt(i) =='E'){
    				Token newToken = new Token(2, s.substring(i, i+1));
    				res.add(newToken);
    			}else
    				return false;
    		}
        }
    	return true;
    }

}

class Token{
	int tokenClass;   // 0 for Digits, 1 for dot, 2 for 'e', 3 for '+' and '-'
	String val;
	
	Token(int tc, String str){
		tokenClass = tc;
		val = str;
	}
}
