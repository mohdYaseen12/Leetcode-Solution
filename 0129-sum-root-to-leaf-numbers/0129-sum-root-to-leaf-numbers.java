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
    private int sumOfNodes(TreeNode currNode, int currSum){
        if(currNode == null) return 0;
        
        if(currNode.left == null && currNode.right == null) return currSum = currSum * 10 + currNode.val;
        
        return sumOfNodes(currNode.left,currSum * 10 + currNode.val) + sumOfNodes(currNode.right,currSum * 10 + currNode.val);
        
    }
    
    public int sumNumbers(TreeNode root) {
        return sumOfNodes(root,0);
    }
}