package leet_code.leet_code_0101_0150.leet_code_0103;

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> floors = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                List<Integer> list = result.get(i);
                List<Integer> item = new ArrayList<>();
                for (int j = list.size() - 1; j >= 0; j--) {
                    item.add(list.get(j));
                }
                result.set(i, item);
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