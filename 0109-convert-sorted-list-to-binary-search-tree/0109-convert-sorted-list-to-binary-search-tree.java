/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
//     private ListNode getMiddle(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
    public TreeNode sortedListToBST(ListNode head) {
//         if(head == null) return null;
//         if(head.next == null) return new TreeNode(head.val);
        
//         ListNode mid = getMiddle(head);
        
//         TreeNode tree = new TreeNode(mid.val);
//         tree.left = sortedListToBST(head);
//         ListNode rightPart = mid.next;
//         mid.next = null;
        
        
//         tree.right = sortedListToBST(rightPart);
//         return tree;
      
         if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode res=new TreeNode(slow.next.val);
        ListNode righthalf=slow.next.next;
        slow.next=null;
        res.left=sortedListToBST(head);
        res.right=sortedListToBST(righthalf);
        return res;
       
    }
}