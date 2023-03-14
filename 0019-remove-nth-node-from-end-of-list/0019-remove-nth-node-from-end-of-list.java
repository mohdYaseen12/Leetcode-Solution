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
    private int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        if(len == n){
            head = head.next;
            return head;
        }
        int idx = 1;
            ListNode prev = head;
            while(idx < len-n){
                prev = prev.next;
                idx++;
            }
            
            ListNode target = prev.next;
            prev.next = target.next;
            target.next = null;
            return head;
    }
}