package leet_code.leet_code_0101_0150.leet_code_0113;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        find(root, 0, sum);
        return result;
    }

    void find(TreeNode node, int sum, int aim) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum + node.val == aim) {
                List<Integer> item = new ArrayList<>();
                for (int i : stack) {
                    item.add(i);
                }
                item.add(node.val);
                result.add(item);
            }
            return;
        }
        stack.push(node.val);
        find(node.left, sum + node.val, aim);
        find(node.right, sum + node.val, aim);
        stack.pop();
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