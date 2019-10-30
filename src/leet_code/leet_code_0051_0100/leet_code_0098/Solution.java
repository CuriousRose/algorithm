package leet_code.leet_code_0051_0100.leet_code_0098;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    boolean check(TreeNode node, Integer l, Integer r) {
        if (node == null) {
            return true;
        }
        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            if (l != null) {
                if (node.left.val <= l) {
                    return false;
                }
            }
        }
        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            if (r != null) {
                if (node.right.val >= r) {
                    return false;
                }
            }
        }
        return check(node.left, l, node.val) && check(node.right, node.val, r);
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