/**
 * medium
 * 
 * 稍微有recursion的思路，但是还是写不出来，问题出现在对递归栈的使用不够清晰，不知道具体每一层的返回
 * 下面这个只是一种方法，可以多次尝试其他方法，我把这个解法的思路图放在readme
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
    
    public int goodNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int max = -99999;
        
        return dfs(root, max);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        } 
        int counter = 0;
        if (root.val >= max) {
             counter = 1;
        }
        
        int left = dfs(root.left, Math.max(root.val, max));
        counter = counter + left;
        int right = dfs(root.right, Math.max(root.val, max));
        counter = counter + right;
        return counter;
    }
}