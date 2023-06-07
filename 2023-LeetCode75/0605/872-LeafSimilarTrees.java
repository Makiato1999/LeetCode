/**
 * easy
 * 
 * 和104很像，我现在大概能知道在这种需要节点往回走的情况下要用recursion，并且在递归外存值的方法也值得多复习
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        saveLeaves(root1, list1);
        saveLeaves(root2, list2);

        return list1.equals(list2);
    }

    public void saveLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            saveLeaves(root.left, list);
            saveLeaves(root.right, list);
        }
    }
}