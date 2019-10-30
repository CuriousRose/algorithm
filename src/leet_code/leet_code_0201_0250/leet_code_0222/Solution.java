package leet_code.leet_code_0201_0250.leet_code_0222;

/**
 * @author chj
 * @date 2019/6/28 11:21
 * 二叉树
 * 11:25
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
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