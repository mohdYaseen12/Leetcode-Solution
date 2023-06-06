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
    public int numComponents(ListNode head, int[] nums) {
        if(head == null) return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int component = 0;
        ListNode curr = head;
        boolean flag = false;
        while(curr != null){
            if(set.contains(curr.val)){
                flag = true;
            }
            else{
                if(flag)
                    component++;
                flag = false;
                
            }
            curr = curr.next;
        }
        if(flag ) component++;
        return component;
    }
}