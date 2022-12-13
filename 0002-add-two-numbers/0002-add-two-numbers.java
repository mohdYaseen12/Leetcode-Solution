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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            ListNode nn = new ListNode(sum % 10);
            head.next = nn;
            carry = sum / 10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // if some node left of list1.
        while(l1 != null){
            int sum = l1.val + carry;
            ListNode nn = new ListNode(sum % 10);
            head.next = nn;
            carry = sum / 10;
            head = head.next;
            l1 = l1.next;
        }
        // if some node left of list2.
        while(l2 != null){
            int sum = l2.val + carry;
            ListNode nn = new ListNode(sum % 10);
            head.next = nn;
            carry = sum / 10;
            head = head.next;
            l2 = l2.next;
        }
        // if carry is non zero
        if(carry != 0){
            ListNode nn = new ListNode(carry % 10);
            head.next = nn;
            carry = carry / 10;
            head = head.next;
        }
        return dummy.next;
    }
}