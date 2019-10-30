package leet_code.leet_code_0101_0150.leet_code_0109;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(list.toArray(new Integer[list.size()]), 0, list.size() - 1);
    }

    TreeNode build(Integer[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = (l + r) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = build(nums, l, m - 1);
        node.right = build(nums, m + 1, r);
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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