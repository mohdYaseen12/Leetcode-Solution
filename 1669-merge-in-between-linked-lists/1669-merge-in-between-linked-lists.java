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
//     private ListNode findNode(ListNode head, int target){
//         while(head != null){
//             if(head.next.val == target){
//                 return head;
//             }
//             head = head.next;
//         }
//         return null;
//     }
    
//     private ListNode findLastNode(ListNode head){
//         while(head.next != null) head = head.next;
//         return head;
//     }
    
    
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
     
       // create the copy pointers and the return pointer

        ListNode ret = list1;
        ListNode curr = list1;
        ListNode curr2 = list1;
        
        // Take the first pointer to location a. 
        
        while(a>1){
            a--;
            curr = curr.next;
        }
        
        
        // take the second pointer ro location b.

        while(b>0){
            b--;
            curr2 = curr2.next;
        }
        curr2 = curr2.next;
        
        // connecting first pointer to list2

        curr.next = list2;
        
        // traverse thorugh list2 and connect the end to second pointer

        while(list2.next!=null){
            list2 = list2.next;
        } 
        list2.next = curr2;
        return ret;
        
        
    }
}