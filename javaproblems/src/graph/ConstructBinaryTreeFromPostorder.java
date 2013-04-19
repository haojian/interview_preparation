package graph;

public class ConstructBinaryTreeFromPostorder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] postorder = {2, 1};
		int[] inorder = {2, 1};
		TreeNode tmp = buildTree(inorder, postorder);
		System.out.println(tmp.val);
	}

	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(inorder == null || postorder == null || postorder.length != inorder.length || postorder.length == 0)
    		return null;
    	int[] trackerPostorder = new int[1];
    	trackerPostorder[0] = postorder.length-1;
    	TreeNode root = new TreeNode(postorder[trackerPostorder[0]]);
    	trackerPostorder[0]--;
    	int split = findIndexByVal(inorder,root.val, 0, inorder.length);
    	root.right = buldTreeRecur(inorder, postorder, split+1, inorder.length, trackerPostorder);
        root.left = buldTreeRecur(inorder, postorder, 0, split, trackerPostorder);
        return root;
    }
    
    public static TreeNode buldTreeRecur(int[] inorder, int[] postorder, int siInorder, int eiInorder, int[] trackerPostorder){
    	if(trackerPostorder[0] >= postorder.length || trackerPostorder[0]<0 )
    		return null;
    	
    	int split = findIndexByVal(inorder, postorder[trackerPostorder[0]], siInorder, eiInorder);
    	
    	if(split == -1)
    		return null;
    	TreeNode root = new TreeNode(postorder[trackerPostorder[0]]);
    	trackerPostorder[0]--;
    	root.right = buldTreeRecur(inorder, postorder, split+1, eiInorder, trackerPostorder);
    	root.left = buldTreeRecur(inorder, postorder, siInorder, eiInorder, trackerPostorder);
    	return root;
    }
    
    public static int findIndexByVal(int[] inorder, int target, int si, int ei){
    	for(int i=si; i<ei; i++){
    		if(inorder[i] == target)
    			return i;
    	}
    	return -1;
    }
    
}
