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
		
		ArrayList<ArrayList<String>> output = comb(lists);
		
	}
	static int solutionCounter = 1;

	public static ArrayList<ArrayList<String>> comb(ArrayList<ArrayList<String>> lists){
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
		int factor = 1;
		for(int k = j; k<lists.size(); k++){
			factor *= lists.get(k).size();
		}
		return i%factor;
	}

}
