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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        int level = 1;
        q.add(root);
        int ans = 0;
        int sum = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int len = q.size();
            int currSum = 0;
            while(len > 0){
                TreeNode curr = q.poll();
                currSum += curr.val;
                
                if(curr.left != null) q.add(curr.left);
                
                if(curr.right != null) q.add(curr.right);
                len--;
            }
            
            if(currSum > sum){
                sum = currSum;
                ans = level;
            }
            level++;
            
            
        }
        return ans;
    }
}