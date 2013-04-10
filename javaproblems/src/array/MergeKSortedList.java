package array;

import java.util.ArrayList;

public class MergeKSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> tmp = new ArrayList<ListNode>();
		tmp.add(new ListNode(0));
		//tmp.subList(0, 0);
		mergeKLists(tmp);
	}
	
	public static ArrayList<ListNode> getSubList(ArrayList<ListNode> lists, int si, int ei){
		ArrayList<ListNode> res = new ArrayList<ListNode>();
		for(int i= si; i<ei; i++){
			res.add(lists.get(i));
		}
		return res;
	}
	
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int mid = lists.size()/2;
         return mergeLists(getSubList(lists, 0, mid), getSubList(lists, mid, lists.size()));
    }
    
    public static ListNode mergeLists(ArrayList<ListNode> list1, ArrayList<ListNode> list2){
        if(list1.size() == 1 && list2.size() == 1){
            //do merge
            ListNode head = new ListNode(0);
            ListNode tracker = head;
            ListNode tracker1 = list1.get(0);
            ListNode tracker2 = list2.get(0);
            while(tracker1!=null && tracker2!=null){
                if(tracker1.val < tracker2.val){
                    tracker.next = tracker1;
                    tracker1 = tracker1.next;
                    tracker = tracker.next;
                }else{
                    tracker.next = tracker2;
                    tracker2 = tracker2.next;
                    tracker = tracker.next;
                }
            }
            tracker.next = tracker1==null?tracker2:tracker1;
            return head.next;
        }else if(list1.size()==1 && list2.size() == 0){
        	return list1.get(0);
        }else if(list1.size() == 0 && list2.size() == 1){
        	return list2.get(0);
        }else if(list1.size() == 0 && list2.size() == 0){
        	return null;
        }
        else if(list1.size() == 0){
            int mid = list2.size()/2;
            return mergeLists(getSubList(list2, 0, mid), getSubList(list2, mid, list2.size()));
        }
        else if(list2.size() == 0){
            int mid = list1.size()/2;
            return mergeLists(getSubList(list1, 0, mid), getSubList(list1, mid, list1.size()));
        }
        else{
            int mid1 = list1.size()/2;
            ListNode tmp1=  mergeLists(getSubList(list1, 0, mid1), getSubList(list1, mid1, list1.size()));
            int mid2 = list2.size()/2;
            ListNode tmp2 = mergeLists(getSubList(list2, 0, mid2), getSubList(list2, mid2, list2.size()));
            
            ArrayList<ListNode> alist1 = new ArrayList<ListNode>();
            alist1.add(tmp1);
            ArrayList<ListNode> alist2 = new ArrayList<ListNode>();
            alist2.add(tmp2);
            return mergeLists(alist1, alist2);
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
