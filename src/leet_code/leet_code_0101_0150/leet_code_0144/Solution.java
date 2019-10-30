package leet_code.leet_code_0101_0150.leet_code_0144;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树 遍历
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        before(root);
        return result;
    }

    void before(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        before(node.left);
        before(node.right);
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