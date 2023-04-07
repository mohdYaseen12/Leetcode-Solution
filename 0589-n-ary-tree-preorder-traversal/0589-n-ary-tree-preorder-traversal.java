/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list= new ArrayList<>();
     if(root==null){
         List<Integer> list1= new ArrayList<>();
          return list1;
     }

     list.add(root.val);

     for(int i=0;i<root.children.size();i++){
         Node temp=root.children.get(i);
       //  list.add(temp.val);
         List<Integer> list2=new ArrayList<>();
         list2= preorder(temp);
         int k=0;
         while(k<list2.size()){
             list.add(list2.get(k));
             k++;
         }
         

     }

        return list;
    }
}