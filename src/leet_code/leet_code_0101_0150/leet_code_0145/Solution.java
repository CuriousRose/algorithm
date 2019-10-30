package leet_code.leet_code_0101_0150.leet_code_0145;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树 遍历
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        after(root);
        return result;
    }

    void after(TreeNode node) {
        if (node == null) {
            return;
        }
        after(node.left);
        after(node.right);
        result.add(node.val);
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