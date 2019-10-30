package leet_code.leet_code_0101_0150.leet_code_0108;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = (l + r) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = build(nums, l, m - 1);
        node.right = build(nums, m + 1, r);
        return node;
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