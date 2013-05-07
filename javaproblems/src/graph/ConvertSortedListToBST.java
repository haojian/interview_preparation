package graph;

public class ConvertSortedListToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = 0;
        ListNode tmp = head;
        while(tmp != null){
        	length++;
        	tmp=tmp.next;
        }
        ListNode[] refHead = new ListNode[1];
        refHead[0] = head;
        return buildBSTBottomUp(refHead, 0, length);
    }
    
    // ei was not included
    public TreeNode buildBSTBottomUp(ListNode[] head, int si, int ei){
    	if(si>=ei)
    		return null;
    	int mid = si + (ei-si)/2;
    	TreeNode left = buildBSTBottomUp(head, si, mid);
    	TreeNode root = new TreeNode(head[0].val);
    	root.left = left;
    	head[0] = head[0].next;
    	root.right = buildBSTBottomUp(head, mid+1, ei);
    	return root;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; next = null; }
}
