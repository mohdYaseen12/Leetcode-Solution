/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // building relation between child and parent
    private void getParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        if(root == null) return;
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right,root);
        getParent(root.left,parent);
        getParent(root.right,parent);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParent(root,parent);
        
        Set<TreeNode> vis = new HashSet<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node == null || vis.contains(node)) continue;
                
                // visiting cuur node
                vis.add(node);
                
                if(level == k){
                    ans.add(node.val);
                }
                q.add(node.left);
                q.add(node.right);
                q.add(parent.get(node));
            }
            level++;
        }
        return ans;
    }
}

// target -> 1st step -> to find the target node
// dfs -> k distance ele
//