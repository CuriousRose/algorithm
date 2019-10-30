package leet_code.leet_code_0251_0300.leet_code_0270;

/**
 * @author chj
 * @date 2019/8/12 9:43
 * 二叉搜索树
 * 09:50
 */
class Solution {

    double min = Double.MAX_VALUE;
    int record = 0;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return record;
        }
        if (Math.abs(root.val - target) <= min) {
            min = Math.abs(root.val - target);
            record = root.val;
        }
        if (root.val < target) {
            return closestValue(root.right, target);
        } else {
            return closestValue(root.left, target);
        }
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

