package leet_code.leet_code_0201_0250.leet_code_0230;

/**
 * @author chj
 * @date 2019/7/1 10:28
 * 二叉搜索树
 * 10:40
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return find(root, k).value;
    }

    Result find(TreeNode node, int index) {
        if (node == null) {
            return new Result(-1, 0);
        }
        Result lr = find(node.left, index);
        if (lr.value != -1) {
            return lr;
        }
        if (lr.count + 1 == index) {
            return new Result(node.val, 0);
        }
        Result rr = find(node.right, index - lr.count - 1);
        if (rr.value != -1) {
            return rr;
        }
        return new Result(-1, lr.count + 1 + rr.count);
    }

    class Result {
        int value;
        int count;

        Result(int value, int count) {
            this.value = value;
            this.count = count;
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