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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val); // min type pq
        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        
        //normal bfs template
        while(!pq.isEmpty()){
            ListNode rnode = pq.remove();
            tail.next = rnode; // add at the end
            tail = tail.next; // move to next
            
            if(tail.next != null) pq.add(tail.next);
        }
        
        return head.next;
    }
}