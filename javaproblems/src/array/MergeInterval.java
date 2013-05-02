package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

	/**
	 * 
	 * 
	 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(intervals == null || intervals.size() == 0){
    		return intervals;
    	}
    	Collections.sort(intervals, INTERVAL_ORDER);
    	ArrayList<Interval> res = new ArrayList<Interval>();
    	int s = intervals.get(0).start;
    	int e = intervals.get(0).end;
    	for(int i=1; i<intervals.size(); i++){
    		if(e >= intervals.get(i).start){
    			e = Math.max(intervals.get(i).end, e) ;
    		}else{
    			res.add(new Interval(s, e));
    			s= intervals.get(i).start;
    			e = intervals.get(i).end;
    		}
    	}
    	res.add(new Interval(s, e));
        return res;
    }
    
    static final Comparator<Interval> INTERVAL_ORDER = new Comparator<Interval>(){
        public int compare (Interval i, Interval j) {
            return new Integer(i.start).compareTo(new Integer(j.start));
        }
    };
}
class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      }