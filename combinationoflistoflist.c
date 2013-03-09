Haojian Jin.  :)
Homepage: http://shift-3.com
Github: https://github.com/haojian

Q. Write an iterator over combinations of options, as described in the example:

{{1, 2, 3} {a, b} {d, e, f}} ->
{1, a, d}
{1, a, e}
...
{2, b, f}
...
{3, b, f}

public Iterator<List<T>> combinations(List<List<T>> optionsLists);
iterator:
http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Iterator.html


so there are 18 possibilities for that example?



T = List<List<T>>.get(index)
C int[][] array  4* 5. 
index 17

http://docs.oracle.com/javase/6/docs/api/java/util/List.html
    int solutionCounter = 1;

{
    List<List<T> res = new List<List<T>>();

    for(int i = 0; i < optionLists.size(); i++){
        solutionCounter *= optionLists.get(i).size();
    }
    for(int i = 0; i < solutionCounter; i++){
        int j = 0;
        int trackerindex = 0;
        List<T> singlelist = new List<T>();
        for(List<T> subList: optionLists){
            //get the candidate based on i & j.
            //%
            j++;
            singlelist.add(subList.get(trackerindex));
            trackerindex = getTrackerIndex(i, optionLists, j);
        }
        res.add(singlelsit);
    }
    return res.iterator();
}

int getTrackerIndex(int i,  List<List<T>> optionLists, int j){
    
    for()
    (trackerindex++) % subList.size();
}

        for(int 
    }
    //dfs to the search first.
    //
    List<List<T> res = new List<List<T>>();
    vector<T> tmpStoragee = new Vector<T>();
    for(int i = 0; i< optionLists.size(); i++){
        tmpStorage.add(optionsList.get(i));
    }
}


public static void comb()


{
    List<List<T>> res = new list<List<T>>();
    List<T> tmp = new List<List<T>>();
    
    
    for(int i = 0; i< optionLists.size(); i++){
        
        for(int j = 0; j<optionList.get(i).size(); j++){
            tmp.add(optionsList.get(i));
            //check if this list already contain that element.
            ..
        }
    }
    //Map<String, boolean> map = new HashMap<String, boolean>();

    for(Iterator<List<T>> it = optionslists.iterator(); it.hashNext()){
        
        for(Iterator<List<T>> subit = optionslists.iterator(); subit.hashNext()){
        }    
    }
}


int[] trackers = new int[lists.size()];

List<T> tmp = new List<T>();
for(int i=0; i<lists.size(); i++){
	for(int j = 0; j<list.get(i); j++){
		if()
	}
}