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
    void findParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        if(root == null){
            return;
        }
        if(root.left != null){
            parent.put(root.left,root);
        }
        if(root.right != null){
            parent.put(root.right, root);
        }
        findParent(root.left,parent);
        findParent(root.right,parent);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>(); // child -> parent map
        findParent(root,parent);
        
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(target);
        visited.add(target);
        
        while(q.size() != 0){
            int size = q.size();
            if( k == 0){
                while(q.size() != 0){
                    TreeNode temp = q.remove();
                    
                    ansList.add(temp.val);
                }
                return ansList;
            }
            while(size > 0){
                TreeNode rnode = q.remove();
                
                
                // add left child if available
                if(rnode.left != null && visited.contains(rnode.left) == false){
                    visited.add(rnode.left);
                    q.add(rnode.left);
                }
                
                // add right child if available
                if(rnode.right != null && visited.contains(rnode.right) == false){
                    visited.add(rnode.right);
                    q.add(rnode.right);
                }
                
                // add parent to child if available
                
                if(parent.getOrDefault(rnode,null) != null && visited.contains(parent.get(rnode)) == false){
                    visited.add(parent.get(rnode));
                    q.add(parent.get(rnode));
                }
                size--;
            }
            k--;
        }
        return ansList;
    }
}