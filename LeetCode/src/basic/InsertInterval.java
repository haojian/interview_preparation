package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 2));
		input.add(new Interval(3, 5));
		input.add(new Interval(6, 7));
		input.add(new Interval(8, 10));
		input.add(new Interval(12, 16));

		insert(input, new Interval(4, 9));
		System.out.println(input);
	}
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval tmp = newInterval;
        for(Interval i:intervals){
        	if(i.end < tmp.start)
        		res.add(i);
        	else if(i.start > tmp.end){
        		res.add(tmp);
        		tmp = i;
        	}
        	else{
        		tmp = new Interval(Math.min(i.start, tmp.start), Math.max(i.end, tmp.end));
        	}
        }
        res.add(tmp);
        return res;
    }
	
	/*
	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    	
	    	int[] flag = new int[2];
	    	flag[0] = -1;
	    	flag[1] = -1;
	    	for(int i=0; i<intervals.size(); i++){
	    		if(intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start)
	    			flag[0] = i;
	    		if(intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end)
	    			flag[1] = i;
	    	}
	    	if(flag[0] == -1 && flag[1] == -1){
	    		
	    		intervals.add(newInterval);
	    	}
	    	else if(flag[0] == -1){
	    		intervals.get(flag[1]).start = newInterval.start;
	    	}else if(flag[1] == -1){
	    		intervals.get(flag[0]).end = newInterval.end;
	    	}else{
	    		int ei = flag[1];
	    		int si = flag[0];
	    		if(si == ei)
	    			return intervals;
	    		Interval replace = new Interval(intervals.get(si).start, intervals.get(ei).end);
	    		for(int i=ei; i>=si; i--){
	    			intervals.remove(i);
	    		}
	    		intervals.add(si, replace);
	    		//intervals.add(replace);
	    	}
	    	//Collections.sort(intervals, comp);
			return intervals;
	    }
	    */
	/*
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	Comparator<Interval> comp = new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.start, o2.start);
			}
    	};
    	Collections.sort(intervals, comp);
    	int[] flag = new int[2];
    	flag[0] = -1;
    	flag[1] = -1;
    	for(int i=0; i<intervals.size(); i++){
    		if(intervals.get(i).start <= newInterval.start && intervals.get(i).end >= newInterval.start)
    			flag[0] = i;
    		if(intervals.get(i).start <= newInterval.end && intervals.get(i).end >= newInterval.end)
    			flag[1] = i;
    	}
    	if(flag[0] == -1 && flag[1] == -1)
    		intervals.add(newInterval);
    	else if(flag[0] == -1){
    		intervals.get(flag[1]).start = newInterval.start;
    	}else if(flag[1] == -1){
    		intervals.get(flag[0]).end = newInterval.end;
    	}else{
    		int ei = flag[1];
    		int si = flag[0];
    		if(si == ei)
    			return intervals;
    		Interval replace = new Interval(intervals.get(si).start, intervals.get(ei).end);
    		for(int i=ei; i>=si; i--){
    			intervals.remove(i);
    		}
    		intervals.add(si, replace);
    		//intervals.add(replace);
    	}
    	//Collections.sort(intervals, comp);
		return intervals;
    }
    */
}

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      @Override
	      public String toString(){
			return start + "-" + end;
	      }
	      }
