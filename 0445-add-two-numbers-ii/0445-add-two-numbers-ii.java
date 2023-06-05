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
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
           ListNode nextOfCurr = curr.next;
            
            curr.next = prev;
            prev = curr;
            
            curr = nextOfCurr;
        }
        head = prev;
        return head;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        // while(l1 != null){
        //     System.out.print(l1.val + " ");
        //     l1 = l1.next;
        // }
        
        // while(l2 != null){
        //     System.out.print(l2.val + " ");
        //     l2 = l2.next;
        // }
        
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            ListNode newNode = new ListNode(sum%10);
            
            head.next = newNode;
            carry = sum/10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // if some node of list 1 remains
        while(l1 != null){
            int sum = l1.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum /10;
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
        }
        
        // if some node of list 2 remains
        while(l2 != null){
            int sum = l2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = newNode;
            head = head.next;
            l2 = l2.next;
        }
        
        // if carry is not 0
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            carry = carry/10;
            head.next = newNode;
            
        }
        
        return reverse(dummy.next);
    }
}