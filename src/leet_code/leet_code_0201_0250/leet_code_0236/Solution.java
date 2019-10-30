package leet_code.leet_code_0201_0250.leet_code_0236;

import java.util.Stack;

/**
 * @author chj
 * @date 2019/7/4 10:02
 * 二叉树 栈
 * 10:14
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        find(root, p.val, ps);
        find(root, q.val, qs);
        TreeNode node = null;
        while (!ps.isEmpty() && !qs.isEmpty()) {
            TreeNode pn = ps.pop();
            TreeNode qn = qs.pop();
            if (pn.val == qn.val) {
                node = pn;
            } else {
                break;
            }
        }
        return node;
    }

    boolean find(TreeNode node, int aim, Stack<TreeNode> stack) {
        if (node == null) {
            return false;
        }

        if (node.val == aim) {
            stack.push(node);
            return true;
        }

        if (find(node.left, aim, stack) || find(node.right, aim, stack)) {
            stack.push(node);
            return true;
        }

        return false;
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