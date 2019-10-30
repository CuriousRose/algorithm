package leet_code.leet_code_0251_0300.leet_code_0298;

/**
 * @author chj
 * @date 2019/8/20 9:36
 * 二叉树 搜索(深度优先)
 * 10:05
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    int max = 0;

    void dfs(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        max = deep > max ? deep : max;
        if (node.left != null && node.left.val - node.val == 1) {
            dfs(node.left, deep + 1);
        } else {
            dfs(node.left, 1);
        }

        if (node.right != null && node.right.val - node.val == 1) {
            dfs(node.right, deep + 1);
        } else {
            dfs(node.right, 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}