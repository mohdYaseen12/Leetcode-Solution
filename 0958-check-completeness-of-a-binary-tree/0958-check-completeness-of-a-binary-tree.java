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
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean last = false;
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null) last = true; // first time a empty node is encountered.
            else{
                // will come to this when curr node is not null
                // if an empty node is already encountered then we return false
                if(last == true) return false; 
                
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}