package leet_code.leet_code_0101_0150.leet_code_0112;

class Solution {
    boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        check(root, 0, sum);
        return result;
    }

    void check(TreeNode node, int sum, int aim) {
        if (result) {
            return;
        }
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.val == aim) {
                result = true;
                return;
            }
        }
        check(node.left, sum + node.val, aim);
        check(node.right, sum + node.val, aim);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}