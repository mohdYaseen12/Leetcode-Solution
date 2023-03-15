/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
    
    private ListNode intersect(ListNode headA,ListNode headB){
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        if(lenA > lenB){
            for(int i=0;i<lenA-lenB;i++){
                headA = headA.next;
            }
            return intersect(headA,headB);
        }
        else if(lenA < lenB){
            for(int i=0;i<lenB-lenA;i++){
                headB = headB.next;
            }
            return intersect(headA,headB);
        }
        else return intersect(headA,headB);
        
        // return null;
    }
}