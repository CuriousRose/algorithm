package leet_code.leet_code_0251_0300.leet_code_0272;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/12 10:30
 * 二叉搜索树 搜索(深度优先) 双指针
 * 10:38
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        dfs(root);
        int l = 0;
        int r = list.size() - 1;
        while (r - l + 1 > k) {
            if (Math.abs(target - list.get(l)) < Math.abs(target - list.get(r))) {
                r--;
            } else {
                l++;
            }
        }
        return list.subList(l, r + 1);
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
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