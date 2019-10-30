package leet_code.leet_code_0151_0200.leet_code_0156;

/**
 * 二叉树
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
        System.out.println(solution.upsideDownBinaryTree(treeNode).val);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        build(root);
        return head;
    }

    TreeNode head = null;

    void build(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null) {
            if (head == null) {
                head = node;
            }
            return;
        } else {
            build(left);
            build(right);
        }

        left.left = right;
        left.right = node;
        node.left = null;
        node.right = null;
        return;
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