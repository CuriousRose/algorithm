package leet_code.leet_code_0151_0200.leet_code_0173;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
class BSTIterator {
    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        build(root);
    }

    void build(TreeNode node) {
        if (node == null) {
            return;
        }

        build(node.left);
        list.add(node.val);
        build(node.right);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
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