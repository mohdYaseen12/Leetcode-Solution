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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        	List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) return zigzag;
		Queue<TreeNode> q = new ArrayDeque<>();
	
		q.add(root);
		int level = 0;
		while(q.size() != 0){
			int size = q.size();
			List<Integer> currLevel = new ArrayList<>();
			while(size > 0){
				TreeNode rnode = q.remove();
				currLevel.add(rnode.val);
				if(rnode.left != null){
					q.add(rnode.left);
				}
				if(rnode.right != null){
					q.add(rnode.right);
				}
				size--;
			}

			if(level % 2 != 0){
				Collections.reverse(currLevel);
			}
			// for(int val : currLevel){
			// 	System.out.print(val + " ");
			// }
            
            zigzag.add(currLevel);
			
			level++;
		}
        return zigzag;
    }
}