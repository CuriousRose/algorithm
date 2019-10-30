package leet_code.leet_code_0101_0150.leet_code_0129;

class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calc(root, 0);
        return sum;
    }

    void calc(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        int value = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += value;
        }
        calc(node.left, value);
        calc(node.right, value);
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