package leet_code.leet_code_0101_0150.leet_code_0111;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return deep(root, 1);
    }

    int deep(TreeNode node, int floor) {
        if (node.left == null && node.right == null) {
            return floor;
        }
        if (node.left == null) {
            return deep(node.right, floor + 1);
        }
        if (node.right == null) {
            return deep(node.left, floor + 1);
        }
        return Math.min(deep(node.left, floor + 1), deep(node.right, floor + 1));
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