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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        
        if(head == null) return null;
        
        int num = 1;
        ListNode curr = head;
        
        while(curr != null){
            int count = 0;
            ListNode start = curr;
            Stack<Integer> st = new Stack<>();
            
            while(count != num && curr != null){
                st.push(curr.val);
                curr = curr.next;
                count++;
            }
            
            if(count % 2 == 0){
                // this is not actually reversing node but copying one node's data to another node
                while(!st.isEmpty() && start != curr ){
                    start.val = st.pop();
                    start = start.next;
                }
            }
            
            num++;
        }
        return head;
    }
}