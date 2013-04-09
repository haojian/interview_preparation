package combinatorics;

import java.awt.List;
import java.util.ArrayList;

public class Comb_listoflist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();
		tmp.add("1");
		tmp.add("2");
		tmp.add("3");
		lists.add(tmp);
		ArrayList<String> tmp1 = new ArrayList<String>();
		tmp1.add("a");
		tmp1.add("b");
		lists.add(tmp1);
		ArrayList<String> tmp2 = new ArrayList<String>();
		tmp2.add("d");
		tmp2.add("e");
		tmp2.add("f");
		lists.add(tmp2);
		
		ArrayList<ArrayList<String>> output = comb_nonrecursive(lists);
		
	}
	static int solutionCounter = 1;
	

	//recursive solution
	public static ArrayList<ArrayList<String>> comb_recursive(ArrayList<ArrayList<String>> lists){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(lists.size() == 1){
			//res.add(e)
		}
		return null;
	}
	

	//non recursive solution:
	public static ArrayList<ArrayList<String>> comb_nonrecursive(ArrayList<ArrayList<String>> lists){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(int i =0; i<lists.size(); i++){
			solutionCounter *= lists.get(i).size();
		}
		for(int i = 0; i< solutionCounter; i++){
			ArrayList<String> singleList = new ArrayList<String>();
			for(int j = 0; j<lists.size(); j++){
				int index = getTrackIndex(i, j, lists);
				singleList.add(lists.get(j).get(index));
			}
			res.add(singleList);
		}
		return res;
	}
	
	public static int getTrackIndex(int i, int j, ArrayList<ArrayList<String>> lists){
		int factorA = 1;
		int factorB = 1;
		for(int k = 0; k<j; j++){
			factorA *= lists.get(k).size();
		}
		for(int k=j; k<lists.size(); k++){
			factorB *= lists.get(k).size();
		}

		int index = i%factorB/factorA;
		System.out.println(i + "\t"+ j + "\t" + index);
		return index;
	}

}
