package leet_code.leet_code_0101_0150.leet_code_0110;

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, 0) >= 0;
    }

    int check(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        }

        int ld = check(node.left, deep + 1);
        int rd = check(node.right, deep + 1);
        if (ld < 0 || rd < 0) {
            return -1;
        }

        if (Math.abs(ld - rd) > 1) {
            return -1;
        }

        return Math.max(ld, rd);
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