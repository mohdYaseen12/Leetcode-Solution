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
    
    // int height(TreeNode root){
    //     if(root == null) return 0;
    //     int lh = height(root.left);
    //     int rh = height(root.right);

    //     return Math.max(lh,rh)+1;
    // }
    // public int diameterOfBinaryTree(TreeNode root) {
        
        // if(root == null ) return 0;

        // int getDiaOfLeftSubTree = diameterOfBinaryTree(root.left);

        // int getDiaOfRightSubTree = diameterOfBinaryTree(root.right);

        // int lh = height(root.left);
        // int rh = height(root.right);

        // int myDia = lh + rh;

        // return Math.max(myDia, Math.max(getDiaOfLeftSubTree,getDiaOfRightSubTree));



        // Approach 2 using class Pair.
    // }
    
     class Pair {
		int diameter;
		int height;

		Pair(){
			diameter = 0;
			height = 0;
		}
		Pair(int height, int diameter){
			this.height = height;
			this.diameter = diameter;
		}
	}
	 Pair diameter_(TreeNode root) {
		if(root == null) return new Pair();

		Pair leftSubTree = diameter_(root.left);
		Pair rightSubTree = diameter_(root.right);

		int diaThroughRoot = leftSubTree.height + rightSubTree.height;

		int myHeight = Math.max(leftSubTree.height, rightSubTree.height) + 1;

		int myDiameter = Math.max(diaThroughRoot, Math.max(leftSubTree.diameter, rightSubTree.diameter));

		return new Pair(myHeight, myDiameter);
    }
    public int diameterOfBinaryTree(TreeNode root)  {
        // Your code here
        Pair ans = diameter_(root);
		return ans.diameter;
    }
}