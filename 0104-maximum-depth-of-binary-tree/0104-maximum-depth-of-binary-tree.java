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
    int ans = 0;
    private void solve(TreeNode root, int currDepth){
        if(root == null ) return;
        
        ans = Math.max(ans, currDepth);
        solve(root.left, currDepth+1);
        solve(root.right, currDepth+1);
    
    }
    public int maxDepth(TreeNode root) {
        // Approach 2
        solve(root,1);
        return ans;
        
        // Approach 1
//         if(root == null) return 0;

//         int lh = maxDepth(root.left);
//         int rh = maxDepth(root.right);

//         return Math.max(lh,rh)+1;
    }
}