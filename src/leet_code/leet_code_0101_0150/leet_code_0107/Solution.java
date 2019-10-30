package leet_code.leet_code_0101_0150.leet_code_0107;

import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> floors = new LinkedList<>();
        nodes.add(root);
        floors.add(0);
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int floor = floors.poll();
            if (!map.containsKey(floor)) {
                map.put(floor, new ArrayList<>());
                max = Math.max(floor, max);
            }
            map.get(floor).add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                floors.add(floor + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                floors.add(floor + 1);
            }
        }
        for (int i = max; i >= 0; i--) {
            result.add(map.get(i));
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