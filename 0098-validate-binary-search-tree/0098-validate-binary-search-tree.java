/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean validate(TreeNode root, long lower, long upper){
		if(root == null) return true;
		if(root.val <= lower || root.val >= upper) return false;

		boolean isLeftBst = validate(root.left,lower,root.val);
		boolean isRightBst = validate(root.right,root.val,upper);
		return isLeftBst && isRightBst;
	}
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}