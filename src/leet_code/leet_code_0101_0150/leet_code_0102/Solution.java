package leet_code.leet_code_0101_0150.leet_code_0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> floors = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        nodes.add(root);
        floors.add(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int floor = floors.poll();
            if (result.size() <= floor) {
                result.add(new ArrayList<>());
            }
            result.get(floor).add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                floors.add(floor + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                floors.add(floor + 1);
            }
        }
        return result;
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