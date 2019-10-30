package leet_code.leet_code_0051_0100.leet_code_0099;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        solution.recoverTree(treeNode);
    }

    List<TreeNode> nodes = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        mid(root);
        int l = 0;
        int r = nodes.size() - 1;
        while (l < nodes.size()) {
            if (nodes.get(l).val < nodes.get(l + 1).val) {
                l++;
                continue;
            } else {
                break;
            }
        }
        while (r > 0) {
            if (nodes.get(r).val > nodes.get(r - 1).val) {
                r--;
                continue;
            } else {
                break;
            }
        }
        int val = nodes.get(l).val;
        nodes.get(l).val = nodes.get(r).val;
        nodes.get(r).val = val;
    }

    void mid(TreeNode node) {
        if (node == null) {
            return;
        }
        mid(node.left);
        nodes.add(node);
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