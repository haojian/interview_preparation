package test;

import java.util.ArrayList;

public class Frogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frogs fr = new Frogs(3,2);
		for(int i=0; i< 3; i++){
			//System.out.println(fr.next());
			System.out.println(fr.next2());
			}
	}
	
	int nump = -1;
	int pos = -1;
	int curIndex = 0;
	
	int curfrogs = 0;
	ArrayList<String> history = new ArrayList<String>();
	
	public Frogs(int _numPlayers, int _posIndex){
		nump = _numPlayers;
		pos = _posIndex;
		curIndex = pos;
	}
	
	int curfrogs2 = 1;
	public int getLines(int frogs){
		return frogs*2+3;
	}
	
	public String next2(){
		curfrogs2 = 1;
		int tmp = curIndex;
		while(tmp > getLines(curfrogs2)){
			tmp -= getLines(curfrogs2);
			curfrogs2++;
		}
		curIndex += nump;
		if(tmp == 1)
			return curfrogs2 +  (curfrogs2==1?"frog" : "frogs");
		else if(tmp == 2)
			return curfrogs2 * 2 + "eyes";
		else if(tmp == 3)
			return curfrogs2 * 4 + "legs";
		else if(tmp <= curfrogs2 + 3)
			return "In the pond";
		else 
			return "Plop";
	}
	
	public String next(){
		while(curIndex >= history.size()){
			expect(++curfrogs);
		}
		String res = history.get(curIndex);
		curIndex += nump;
		return res;
	}
	
	public void game(int n){
		for(int i=1; i<=n; i++){
			expect(i);
			System.out.println("");
		}
	}
	
	public void expect(int n){
		history.add(n + " frogs");
		history.add(n*2 + " eyes");
		history.add(n*4 + " legs");
		
		for(int i=0; i<n; i++){
			history.add( "In the pond");
		}
		
		for(int i=0; i<n; i++){
			history.add( "Plop");
		}
	}
}
