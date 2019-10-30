package leet_code.leet_code_0101_0150.leet_code_0105;

class Solution {
    int[] before;
    int[] mid;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        before = preorder;
        mid = inorder;
        return build(0, 0, preorder.length - 1);
    }

    TreeNode build(int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(before[index]);
        int root = left;
        while (root <= right) {
            if (before[index] == mid[root]) {
                break;
            } else {
                root++;
            }
        }
        node.left = build(index + 1, left, root - 1);
        node.right = build(index + root - left + 1, root + 1, right);
        return node;
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