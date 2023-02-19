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
    // Tc : O(N) SC: 
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rv = new ArrayList<>();
        if(root == null) return rv;
        Queue<TreeNode> q = new ArrayDeque<>();
        // add root to que
        q.add(root);

        while(q.size() != 0){
            // getting size of cuurent lvl
            int size = q.size();
           
            ArrayList<Integer> curr = new ArrayList<>();
            while(size > 0){
                TreeNode rnode = q.remove();
                curr.add(rnode.val);
                // adding left node
                if(rnode.left != null){
                    q.add(rnode.left);
                }
                // adding right child
                if(rnode.right != null){
                    q.add(rnode.right);
                }
                size--;
            }
            // for(int i=0;i<curr.size();i++){
            //     if(i == curr.size()-1){
            //         rv.add(curr.get(i));
            //     }
            // }
            rv.add(curr.get(curr.size()-1));
        }
        return rv;
    }
}