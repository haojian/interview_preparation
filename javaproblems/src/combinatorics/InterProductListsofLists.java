package combinatorics;

import java.util.ArrayList;

public class InterProductListsofLists {

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
		ArrayList<ArrayList<String>> res = InterProduct_nonrepeat(lists);
		output(res);
	}
	
	public static ArrayList<ArrayList<String>> InterProduct_withRepeat(ArrayList<ArrayList<String>> lists){
		return null;
	}
	
	public static ArrayList<ArrayList<String>> InterProduct_nonrepeat(ArrayList<ArrayList<String>> lists){
		int solutionCounter = 1;
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(ArrayList<String> list:lists)
			solutionCounter *= list.size();
		for(int i = 0; i<solutionCounter; i++){
			ArrayList<String> singleres = new ArrayList<String>();
			int j = 1;
			for(ArrayList<String> list:lists){
				int curIndex = (i/j)%list.size(); 
				singleres.add(list.get(curIndex));
				j *= list.size();
			}
			res.add(singleres);
		}
		return res;
	}
	
	public static void output(ArrayList<ArrayList<String>> lists){
		for(ArrayList<String> list:lists){
			for(String tmp:list){
				System.out.print(tmp + "\t");
			}
			System.out.println("\n");
		}
	}
	
	
	public void process(ArrayList<ArrayList<String>> listsoflists){
		ArrayList<ArrayList<String>> outputset = new ArrayList<ArrayList<String>>();
		for(ArrayList<String> list: listsoflists){
			
		}
		
	}
	
	
	
	
	
	
	

}
