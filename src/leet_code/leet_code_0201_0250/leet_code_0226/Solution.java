package leet_code.leet_code_0201_0250.leet_code_0226;

/**
 * @author chj
 * @date 2019/7/1 9:52
 * 二叉树
 * 09:55
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
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