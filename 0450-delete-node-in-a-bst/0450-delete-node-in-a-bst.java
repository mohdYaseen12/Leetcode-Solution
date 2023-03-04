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
    public int getMin(TreeNode root){
        if(root.left == null) return root.val;
        return getMin(root.left);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key){
            if(root.left == null && root.right == null) return null; // leaf node 
            
            // if one  child is present
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{ // if both left and right children present
                // step 1: find min in right subtree
                int minVal = getMin(root.right);
                //step 2: overwrite
                root.val = minVal;
                //step 3: delete MInval from right subtree
                root.right = deleteNode(root.right,minVal);
            }
            
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else  root.left = deleteNode(root.left,key);
        
        return root;
    }
    
}