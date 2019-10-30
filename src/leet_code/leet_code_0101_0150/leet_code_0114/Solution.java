package leet_code.leet_code_0101_0150.leet_code_0114;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<TreeNode> nodes = new ArrayList<>();

    public void flatten(TreeNode root) {
        mid(root);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).right = nodes.get(i + 1);
            nodes.get(i).left = null;
        }
    }

    void mid(TreeNode node) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        mid(node.left);
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