/**
 * medium
 * 
 * 迭代写起来不难，因为一定是偶数个数就不难。递归不好想
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
    /* iteration
    public int pairSum(ListNode head) {
        ListNode curr = head;
        List<Integer> valList = new ArrayList<>();

        while(curr != null) {
            valList.add(curr.val);
            curr = curr.next;
        }

        int i = 0;
        int j = valList.size()-1;
        int max = 0;

        while(i<j) {
            max = Math.max(max, valList.get(i)+valList.get(j));
            i++;
            j--;
        }
        return max;
    }
    */


    // recursion
    private int max = 0;
    public int pairSum(ListNode head) {
        ListNode curr = head;
        calMax(curr, head);
        return max;
    }
    public ListNode calMax(ListNode node1, ListNode head) {
        // node2是左边，node1是右边
        // 我们其实是先走递归让node1跑到最右，这样递归的时候node1才会从右往左一点点递归回去
        // node2是基于node1的，当node1跑到最右没有了时候，返回head，此时node2是最左边的head
        // 然后比较后得到max的值，在递归后继续让node2（即左边第一个）往右走
        if (node1 == null) {
            return head;
        }
        ListNode node2 = calMax(node1.next, head);
        max = Math.max(max, node1.val+node2.val);
        return node2.next;
    }
}