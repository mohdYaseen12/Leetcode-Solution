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
    public int pairSum(ListNode head) {
         ArrayList<Integer> al = new ArrayList<Integer>();
        while(head != null)
        {
            al.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = al.size()-1;
        int sum = 0;
        while(i < j)
        {
            sum = Math.max(al.get(i)+al.get(j), sum);
            i++;
            j--;
        }
        return sum;
    }
}