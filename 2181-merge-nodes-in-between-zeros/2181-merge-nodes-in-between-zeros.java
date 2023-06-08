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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode curr = head.next;
        int sum = 0;
        
        while(curr != null){
            while(curr.val != 0){
                sum += curr.val;
                curr = curr.next;
            }
            curr = curr.next;
            dummyHead.next = new ListNode(sum);
            dummyHead = dummyHead.next;
            sum = 0;
        }
        return dummy.next;
    }
}