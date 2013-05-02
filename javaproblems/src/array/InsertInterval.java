package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(intervals == null || intervals.size() == 0)
    	{intervals.add(newInterval);
    	return intervals;
    		
    	}
        int s = newInterval.start;
        int e = newInterval.end;
        int leftFound = -1;
        int rightFound = -1;
        for(int i =0;i<intervals.size(); i++){
        	if(leftFound == -1 && s<=intervals.get(i).end && s>=intervals.get(i).start)
        		leftFound = i;
        	if(rightFound == -1 && e<=intervals.get(i).end && e>=intervals.get(i).start)
        		rightFound = i;
        }
        if(newInterval.start<intervals.get(0).start && newInterval.end>intervals.get(intervals.size()-1).end)
        {
        	intervals.clear();
        	intervals.add(newInterval);
        }
        else if(leftFound == -1 && rightFound == -1){
        	intervals.add(newInterval);
        }else if(leftFound == -1){
        	intervals.get(rightFound).start = s;
        }else if(rightFound == -1){
        	intervals.get(leftFound).end = e;
        }else{
        	int max = intervals.get(rightFound).end;
        	int min = intervals.get(leftFound).start;
        	for(int i=rightFound; i>=leftFound; i--){
        		intervals.remove(i);
        	}
        	intervals.add(new Interval(min, max));
        }
    	Collections.sort(intervals, INTERVAL_ORDER);

        return intervals;
    }
    
    static final Comparator<Interval> INTERVAL_ORDER = new Comparator<Interval>(){
        public int compare (Interval i, Interval j) {
            return new Integer(i.start).compareTo(new Integer(j.start));
        }
    };
}
