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
// DFS
class Solution {
    int depth = 0;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            depth = minDepth(root.right) + 1;
        }
        if (root.right == null) {
            depth = minDepth(root.left) + 1;
        }
        if (root.left != null && root.right != null) {
            int left_depth = minDepth(root.left) + 1;
            int right_depth = minDepth(root.right) + 1;
            depth = Math.min(left_depth, right_depth);
        }
        return depth;
    }
}