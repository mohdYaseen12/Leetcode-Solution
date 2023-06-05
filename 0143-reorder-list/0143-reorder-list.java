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
    private ListNode findMiddle(ListNode head){
        // if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextOfCurr = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            
            curr = nextOfCurr;
        }
        return prev;
    }
    
    private ListNode mergeList(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode curr = dummy;
        
        while(p1 != null && p2 != null){
            ListNode nextP1 = p1.next;
            p1.next = null;
            
            ListNode nextP2 = p2.next;
            p2.next = null;
            
            // add p1 first
            curr.next = p1;
            curr = curr.next;
            p1 = nextP1; // move p1 to its next
            
            // add p2
            curr.next = p2;
            curr = curr.next;
            p2 = nextP2;
            
        }
        curr.next = p1;
        return dummy.next;
    }
    
    
    public void reorderList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode midHead = mid.next;
        mid.next = null;
        
        midHead = reverseList(midHead);
        
        head = mergeList(head,midHead);
        
        
    }
}