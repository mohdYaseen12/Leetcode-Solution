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
    public List<List<Integer>> levelOrder(TreeNode root) {
          
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        // start with adding the root
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){

            // in every level perform RPA for every node
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode tmp = q.remove();
                level.add(tmp.val);
                if(tmp.left != null) q.add(tmp.left);
                if(tmp.right != null) q.add(tmp.right);
            }
            ans.add(level);
        }
        return ans;
    }
}