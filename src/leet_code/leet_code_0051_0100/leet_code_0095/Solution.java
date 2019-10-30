package leet_code.leet_code_0051_0100.leet_code_0095;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateTrees(3);
    }

    List<TreeNode> result = new ArrayList<>();
    int[] list;
    boolean[] mark;
    int len;
    Set<String> record = new HashSet<>();

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return result;
        }
        len = n;
        list = new int[n];
        mark = new boolean[n + 1];
        dfs(0);
        return result;
    }

    void dfs(int index) {
        if (index == len) {
            TreeNode treeNode = build();
            StringBuffer buffer = output(treeNode);
            String key = buffer.toString();
            if (!record.contains(key)) {
                record.add(key);
                result.add(treeNode);
            }
            return;
        }
        for (int i = 1; i <= len; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            list[index] = i;
            dfs(index + 1);
            mark[i] = false;
        }
    }

    TreeNode build() {
        TreeNode node = new TreeNode(list[0]);
        for (int i = 1; i < len; i++) {
            insert(node, list[i]);
        }
        return node;
    }

    void insert(TreeNode treeNode, int k) {
        if (k < treeNode.val) {
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(k);
            } else {
                insert(treeNode.left, k);
            }
        } else {
            if (treeNode.right == null) {
                treeNode.right = new TreeNode(k);
            } else {
                insert(treeNode.right, k);
            }
        }
    }

    StringBuffer output(TreeNode treeNode) {
        StringBuffer buffer = new StringBuffer();
        if (treeNode == null) {
            return buffer.append(".");
        }
        buffer.append(treeNode.val);
        buffer.append(output(treeNode.left));
        buffer.append(output(treeNode.right));
        return buffer;
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