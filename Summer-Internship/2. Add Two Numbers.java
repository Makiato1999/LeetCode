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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode res = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            // 4+2=6, val=6, val in node=6%10=6, carry=6/10=0
            // 4+6=10, val=10, val in node=10%10=0, carry=10/10=1
            // 9+9=18, val=18, val in node=18%10=8, carry=18/10=1
            int val = sum + carry;
            res.next = new ListNode(val % 10);
            res = res.next;
            carry = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyNode.next;
    }
}