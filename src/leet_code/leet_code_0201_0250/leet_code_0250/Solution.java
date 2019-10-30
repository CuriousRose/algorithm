package leet_code.leet_code_0201_0250.leet_code_0250;

/**
 * @author chj
 * @date 2019/8/5 11:02
 * 模拟 树
 * 11:43
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        check(root);
        return sum;
    }

    int sum = 0;

    boolean check(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            sum++;
            return true;
        }

        boolean success = true;
        if (node.left != null) {
            if (!check(node.left) || node.left.val != node.val) {
                success = false;
            }
        }
        if (node.right != null) {
            if (!check(node.right) || node.right.val != node.val) {
                success = false;
            }
        }
        if (success) {
            sum++;
            return true;
        } else {
            return false;
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

