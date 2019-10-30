package leet_code.leet_code_0251_0300.leet_code_0297;

/**
 * @author chj
 * @date 2019/8/19 21:39
 * 序列化 二叉树
 * 21:54
 */
public class Codec {

    StringBuffer buffer;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        buffer = new StringBuffer();
        dfs(root);
        return buffer.toString();
    }

    void dfs(TreeNode node) {
        if (node == null) {
            buffer.append(",");
            return;
        }
        buffer.append(node.val).append(",");
        dfs(node.left);
        dfs(node.right);
    }

    int index;

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] vs = data.split(",");
        index = 0;
        return build(vs);
    }

    TreeNode build(String[] vs) {
        TreeNode node = null;
        if (vs[index].equals("")) {
            index++;
            return node;
        } else {
            node = new TreeNode(Integer.parseInt(vs[index]));
            index++;
            if (index < vs.length) {
                node.left = build(vs);
            }
            if (index < vs.length) {
                node.right = build(vs);
            }
            return node;
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