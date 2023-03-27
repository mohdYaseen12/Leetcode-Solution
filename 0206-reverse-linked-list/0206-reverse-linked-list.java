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
    public ListNode reverseList(ListNode head) {
         ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextOfCurr = curr.next; // storing the next curr node.
            // breaking and creating the new connection.
            curr.next = prev;
            prev = curr;

            // pointing to next
            curr = nextOfCurr;
        }
        head = prev;// storing prev to head.
        return head;
    }
}