package leet_code.leet_code_0101_0150.leet_code_0104;

class Solution {
    public int maxDepth(TreeNode root) {
        return deep(root, 0);
    }

    int deep(TreeNode node, int floor) {
        if (node == null) {
            return floor;
        }
        return Math.max(deep(node.left, floor + 1), deep(node.right, floor + 1));
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