/**
 * medium
 * 
 * 这个还挺有意思的，奇偶，双链
 */

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddCurr = head;
        ListNode evenHead = head.next;
        ListNode evenCurr = evenHead;

        while (oddCurr.next != null && oddCurr.next.next != null) {
            oddCurr.next = oddCurr.next.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next; 
            evenCurr = evenCurr.next;
        }
        
        oddCurr.next = evenHead;
        return head;
    }
}