package leet_code.leet_code_0201_0250.leet_code_0235;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/7/1 11:56
 * 二叉搜索树
 * 12:03
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        find(root, p.val, plist);
        find(root, q.val, qlist);
        int index = 0;
        while (index < plist.size() && index < qlist.size()) {
            if (qlist.get(index).val == plist.get(index).val) {
                index++;
            } else {
                break;
            }
        }
        return plist.get(index - 1);
    }

    void find(TreeNode node, int aim, List<TreeNode> route) {
        route.add(node);
        if (node.val == aim) {
            return;
        }
        if (node.val > aim) {
            find(node.left, aim, route);
        } else {
            find(node.right, aim, route);
        }
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