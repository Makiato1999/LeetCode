/**
 * medium
 * 
 * 好玩，算层级，我用的dfs，我感觉dfs这类就要多练习，bfs也可以试一下
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int level = 0;

        dfs(root, list, level);

        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val); 
        }
        dfs(root.right, list, level+1);
        dfs(root.left, list, level+1);
    }
}