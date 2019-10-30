package leet_code.leet_code_0151_0200.leet_code_0199;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        find(root, 0);
        return result;
    }

    void find(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (result.size() <= deep) {
            result.add(node.val);
        } else {
            result.set(deep, node.val);
        }
        find(node.left, deep + 1);
        find(node.right, deep + 1);
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