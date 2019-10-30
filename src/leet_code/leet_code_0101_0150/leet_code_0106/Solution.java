package leet_code.leet_code_0101_0150.leet_code_0106;

class Solution {
    int[] after;
    int[] mid;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mid = inorder;
        after = postorder;
        return build(inorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode build(int index, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(after[index]);
        int root = right;
        while (root >= 0) {
            if (after[index] == mid[root]) {
                break;
            } else {
                root--;
            }
        }
        node.right = build(index - 1, root + 1, right);
        node.left = build(index - right + root - 1, left, root - 1);
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