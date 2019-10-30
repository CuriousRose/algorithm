package leet_code.leet_code_0051_0100.leet_code_0094;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        mid(root);
        return result;
    }

    void mid(TreeNode node) {
        if (node == null) {
            return;
        }
        mid((node.left));
        result.add(node.val);
        mid(node.right);
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