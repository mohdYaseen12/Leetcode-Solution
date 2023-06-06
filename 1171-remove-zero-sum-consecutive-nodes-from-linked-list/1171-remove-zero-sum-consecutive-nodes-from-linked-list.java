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
//         Map<Integer,ListNode> map = new HashMap<>();
//         int sum = 0;
        
//         for(ListNode curr = head; curr != null; curr = curr.next){
//             sum += curr.val;
//             map.put(sum,curr);
//         }
        
//         sum = 0;
        
//         for(ListNode curr = head; curr!= null; curr = curr.next){
//             sum += curr.val;
//             ListNode node = map.get(sum);
            
//             if(sum == 0) head = node.next;
            
//             if(node != curr) curr.next = node.next;
//         }
//         return head;
        
        
        
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        ListNode curr= dummy;
        
        while(curr != null){
            int sum=0;
            ListNode temp=curr.next;

                while(temp != null){
                    sum += temp.val;
                    if(sum == 0){
                        curr.next=temp.next;
                        break;
                    }
                    temp=temp.next;
                }

                if(temp == null){
                    curr=curr.next;
                }

        }
        return dummy.next;
    }
}