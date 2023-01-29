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
    class Pair{
		int maxPathSum;
		int sum;
		Pair(int sum, int maxPathSum){
			this.sum = sum;
			this.maxPathSum = maxPathSum;
		}
	}
	Pair bestPathSum(TreeNode root){
		if(root == null){
			return new Pair(0,Integer.MIN_VALUE);
		}
		Pair leftPair = bestPathSum(root.left);
		Pair rightPair = bestPathSum(root.right);
		
		int bestPathSumFromLeft = Math.max(leftPair.sum,0);
		int bestPathSumFromRight = Math.max(rightPair.sum,0);

		int currPathSum = bestPathSumFromLeft + root.val + bestPathSumFromRight;
		int overAllPathSum = Math.max(currPathSum, Math.max(leftPair.maxPathSum, rightPair.maxPathSum));

		return new Pair(Math.max(bestPathSumFromLeft + root.val, bestPathSumFromRight + root.val),overAllPathSum);
	}
    public int maxPathSum(TreeNode root) {
        return bestPathSum(root).maxPathSum;
    }
}