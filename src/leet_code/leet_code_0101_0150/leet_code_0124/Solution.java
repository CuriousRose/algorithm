package leet_code.leet_code_0101_0150.leet_code_0124;


class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        find(root);
        return max;
    }

    int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int left = find(root.left);
        int right = find(root.right);
        if (left > 0 && right > 0) {
            max = Math.max(max, sum + left + right);
        }
        sum += Math.max(left, right);
        max = Math.max(max, sum);
        return Math.max(sum, 0);
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