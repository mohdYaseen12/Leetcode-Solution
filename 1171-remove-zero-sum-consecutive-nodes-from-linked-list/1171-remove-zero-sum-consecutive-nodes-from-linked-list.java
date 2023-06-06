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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int sum = 0;
        
        for(ListNode curr = head; curr != null; curr = curr.next){
            sum += curr.val;
            map.put(sum,curr);
        }
        
        sum = 0;
        
        for(ListNode curr = head; curr!= null; curr = curr.next){
            sum += curr.val;
            ListNode node = map.get(sum);
            
            if(sum == 0) head = node.next;
            
            if(node != curr) curr.next = node.next;
        }
        return head;
    }
}