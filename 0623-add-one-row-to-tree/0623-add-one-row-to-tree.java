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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();
        if(depth == 1){
            TreeNode nn = new TreeNode(val);
           nn.left = root;
            return nn;
        }
        
        q.add(root);
        for(int i=0;i<depth-2;i++){
            int size = q.size();
            for(int j=0;j<size;j++){
                TreeNode currNode = q.poll();
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            TreeNode tmp = curr.left;
            curr.left = new TreeNode(val);
            curr.left.left = tmp;
            
            tmp = curr.right;
            curr.right = new TreeNode(val);
            curr.right.right = tmp;
        }
        
        return root;
    }
}