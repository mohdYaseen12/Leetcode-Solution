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
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      
      while(q.size() > 0){
          
          int size = q.size();
          for(int i=0;i<size;i++){
              TreeNode tmp = q.remove();
              if(i == size-1) ans.add(tmp.val);
              
              if(tmp.left != null) q.add(tmp.left);
              if(tmp.right != null ) q.add(tmp.right);
          }
      }
      return ans;
    }
}