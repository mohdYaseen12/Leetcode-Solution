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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int noOfNode = 0;
        ListNode currNode = head;
        
        // finding the k+1th node
        while(currNode != null && noOfNode != k){
            currNode = currNode.next;
            noOfNode++;
        }
        
        // if k+1 node is found 
        if(noOfNode == k){
            // reverse list with k+1 node
            currNode = reverseKGroup(currNode,k); 
            while(noOfNode > 0){
                ListNode tmp = head.next;
                head.next = currNode; // head to point in reverse
                currNode = head; // move head of reversed part to a new node
                head = tmp; // move head to the next in direct path
                
                noOfNode--;
            }
            head = currNode;
            
        }
        return head;
    }
}
// 1 2 3 4 5
// ist -> count = 1