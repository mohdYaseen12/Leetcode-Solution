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
    TreeNode constructTree(int[] preorder, int psidx, int peidx, int[] inorder, int isidx, int ieidx){
        if(psidx > peidx) return null;
        
        if(isidx > ieidx) return null;
        
        TreeNode root = new TreeNode(preorder[psidx]);
        
        int val = preorder[psidx];
        int countEle = 0;
        int itr = isidx;
        while(inorder[itr] != val){
            countEle++;
            itr++;
        }
        
        root.left = constructTree(preorder, psidx+1, psidx + countEle, inorder, isidx, itr - 1);
        root.right = constructTree(preorder, psidx+countEle + 1, peidx, inorder, itr+1, ieidx);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length-1, inorder, 0 , inorder.length-1);
    }
}