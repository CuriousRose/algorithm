package leet_code.leet_code_0001_0050.leet_code_0025;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode = solution.reverseKGroup(listNode, 3);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        List<ListNode> lists = new ArrayList<>();
        while (head != null) {
            lists.add(head);
            head = head.next;
        }

        ListNode node = new ListNode(0);
        head = node;

        int i = 0;
        while (i + k <= lists.size()) {
            i += k;
            for (int j = i - 1; j >= i - k; j--) {
                node.next = lists.get(j);
                node = node.next;
                node.next = null;
            }
        }

        for (int j = i; j < lists.size(); j++) {
            node.next = lists.get(j);
            node = node.next;
            node.next = null;
        }


        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}