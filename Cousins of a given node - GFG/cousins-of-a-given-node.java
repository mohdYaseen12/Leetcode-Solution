//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    
    public static Node point(Node root, int n)
    {
        if(root == null)
            return null;
            
        if(root.data == n)
            return root;
            
        Node l = point(root.left, n);
        if(l!=null && l.data==n)
            return l;
            
        Node r= point(root.right, n);
        return r;
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            Node root = buildTree(s);
            
            Node p = point(root,n);
            
            Solution ob=new Solution();
            ArrayList<Integer> ans= ob.printCousins(root, p);
            
            for(int i=0;i<ans.size();i++)
            {
                    System.out.print(ans.get(i)+" ");
    
            }
            
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node a)
    {
        //code here
        ArrayList<Integer> cousin = new ArrayList<>();
        
        // if root node is the node to find (no cousin possible)
        if(root.data == a.data){
            cousin.add(-1);
            return cousin;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean leftOfRight = false;
        boolean rightOfLeft = false;
        boolean right = false;
        
        while(q.size() > 0){
            int len = q.size();
            
            ArrayList<Integer> currLevel = new ArrayList<>();
            boolean flag = false;
            for(int i=0;i<len;i++){
                Node rnode = q.remove();
                currLevel.add(rnode.data);
                if(rnode.data == a.data) flag = true;
                
                // adding left child
            if(rnode.left != null){
                q.add(rnode.left);
                if(rnode.left.data == a.data){
                leftOfRight = rnode.right == null ? true : false;
                    
                }
                
            }
            
            // adding right child
            if(rnode.right != null){
                q.add(rnode.right);
                if(rnode.right.data == a.data){
                    right = true;
                    rightOfLeft = rnode.left == null ? true:false;
                }
            }
                
            }
            if(flag) cousin.addAll(currLevel);
            
            
        }
        int idx = cousin.indexOf(a.data);
        if(leftOfRight || rightOfLeft){
            cousin.remove(idx);
            
        }
        else{
            if(right) idx--;
            cousin.remove(idx);
            cousin.remove(idx);
        }
        if(cousin.size() == 0){
            cousin.add(-1);
            return cousin;
        }
        return cousin;
    }
}