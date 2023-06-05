/**
 * medium
 * 
 * 感觉是easy的程度，没什么难点
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }
        ListNode curr = head;
        int n = 0;
        while(curr != null) {
            n+=1;
            curr = curr.next;
        }
        curr = head;
        int middlePos = n/2;
        int index = 0;
        while(curr != null) {
            if(++index == middlePos) {
                curr.next = curr.next.next;
                break;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }
}