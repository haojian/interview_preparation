package string;

import java.util.ArrayList;

public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		TextJustification tj = new TextJustification();
		System.out.println(tj.fullJustify(words, 16));
	}

	
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> wordsinLine = new ArrayList<String>();
        ArrayList<String> res = new ArrayList<String>();
        int si = 0;
        while(si<words.length){
            if(addtoLine(wordsinLine, words[si], L)){
                si++;
            }else{
                res.add(outputString(wordsinLine, L));
                wordsinLine.clear();
            }
            
        }
        if(!wordsinLine.isEmpty()){
        	String lastline = "";
        	for(String word:wordsinLine){
        		lastline += word;
        		lastline += " ";
        	}
        	lastline = lastline.substring(0, lastline.length()-1);
        	int space = L-lastline.length();
    		String empty = "";
    		while(space>0){
    			empty+=" ";
    			space--;
    		}
    		lastline+=empty;
        	res.add(lastline);
        }
        return res;
    }
    
    public boolean addtoLine(ArrayList<String> line, String word, int L){
        int length = 0;
        for(String wordinline: line){
            length += wordinline.length();
            length +=1;
        }
        if((length + word.length()) <= L){
        	line.add(word);
            return true;
        }
        else
            return false;
    }
    
    public String outputString(ArrayList<String> words, int L){
    	if(words.size() == 1){
    		int space = L-words.get(0).length();
    		String empty = "";
    		while(space>0){
    			empty+=" ";
    			space--;
    		}
    		return words.get(0)+empty;
    	}
        int length = 0;
        for(String word: words){
            length += word.length();
        }
        int empty = L-length;
        int each = empty/(words.size()-1);
        int extra = empty%(words.size()-1);
        String space = "";
        for(int i=0; i<each;i++){
            space += " ";
        }
        String res = "";
        
        for(int i=0; i<words.size(); i++){
        	res+=words.get(i);
        	if(i!= words.size()-1){
        		res+= space;
        	}
        	if(extra != 0)
            {
                res += " ";
                extra--;
            }
        }

        return res;
    }
}
