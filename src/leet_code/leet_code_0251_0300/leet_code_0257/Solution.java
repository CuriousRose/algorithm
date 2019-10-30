package leet_code.leet_code_0251_0300.leet_code_0257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chj
 * @date 2019/8/6 11:40
 * 树 遍历(前序遍历)
 */
class Solution {
    List<String> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        stack.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuffer buffer = new StringBuffer();
            for (int i : stack) {
                buffer.append(i).append("->");
            }
            result.add(buffer.substring(0, buffer.length() - 2));
        }
        dfs(node.left);
        dfs(node.right);
        stack.pop();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

