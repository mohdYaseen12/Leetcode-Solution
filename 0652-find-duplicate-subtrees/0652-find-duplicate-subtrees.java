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
    private String postorder(List<TreeNode> res, HashMap<String,Integer> hm, TreeNode root){
        if(root == null) return "N";
        
        String left = postorder(res,hm,root.left);
        String right = postorder(res,hm,root.right);
        
        String str = root.val + " " + left + " " + right;
        
        hm.put(str, hm.getOrDefault(str,0)+1);
        
        if(hm.get(str) == 2){
            res.add(root);
        }
        return str;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postorder(res, new HashMap<>(),root);
        return res;
    }
}