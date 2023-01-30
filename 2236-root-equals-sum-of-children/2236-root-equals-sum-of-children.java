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
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        
        if(root.left == null && root.right == null) return true;
        
        int childSum = 0;
        if(root.left != null){
            childSum += root.left.val;
            
        }
        if(root.right != null){
            childSum += root.right.val;
        }
        
        boolean isFollwedInLeftSubTree = checkTree(root.left);
        boolean isFollwedInRightSubTree = checkTree(root.right);
        
        if(isFollwedInLeftSubTree == false || isFollwedInRightSubTree == false || childSum != root.val){
            return false;
        }
        else{
            return true;
        }
    }
}