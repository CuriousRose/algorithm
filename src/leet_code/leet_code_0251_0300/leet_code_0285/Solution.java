package leet_code.leet_code_0251_0300.leet_code_0285;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/15 11:17
 * 二叉搜索树 遍历
 * 11:22
 */
class Solution {
    List<TreeNode> nodeList = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        for (int i = 1; i < nodeList.size(); i++) {
            if (nodeList.get(i - 1).val == p.val) {
                return nodeList.get(i);
            }
        }
        return null;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        nodeList.add(node);
        dfs(node.right);
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