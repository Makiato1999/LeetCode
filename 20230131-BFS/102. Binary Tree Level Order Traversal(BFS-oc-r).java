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
 // DFS recursive
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        if (root.left != null) {
            dfs(root.left, result, depth + 1);
            // note: after void recursion,
            // result has updated, but depth will not change
        }
        if (root.right != null) {
            dfs(root.right, result, depth + 1);
        }
    }
}