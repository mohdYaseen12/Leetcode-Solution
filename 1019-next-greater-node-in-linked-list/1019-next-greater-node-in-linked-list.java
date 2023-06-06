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
            len++;
            head = head.next;
        }
        return len;
    }
    
    public int[] nextLargerNodes(ListNode head) {
        int len = getLength(head);
        int[] ans = new int[len];
        
        Stack<int[]> st = new Stack<>();
        
        ListNode curr = head;
        for(int i=0;i<len;i++){
            while(!st.isEmpty() && curr.val > st.peek()[1]){
                ans[st.peek()[0]] = curr.val;
                st.pop();
            }
            st.push(new int[]{i,curr.val});
            
            curr = curr.next;
        }
        return ans;
    }
}