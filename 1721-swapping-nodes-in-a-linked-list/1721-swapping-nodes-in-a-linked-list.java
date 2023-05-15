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
    private ListNode find(ListNode head,int k){
        for(int i=1;i<=k;i++){
            head = head.next;
        }
        return head;
    }
    private int length(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int len = length(head);
        ListNode start = find(head,k-1);
        ListNode last = find(head,len-k);
        // swaping value of kth node from start and kth node from end
        int startVal = start.val;
        int lastVal = last.val;
        start.val = lastVal;
        last.val = startVal;
        return head;
    }
}