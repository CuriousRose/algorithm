package leet_code.leet_code_0001_0050.leet_code_0023.priority;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode node = solution.mergeKLists(new ListNode[]{l1, l2, l3});
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode node = new ListNode(0);
        ListNode head = node;

        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            queue.add(listNode);
        }

        while (!queue.isEmpty()) {
            ListNode item = queue.poll();
            node.next = item;
            node = node.next;

            if (item.next != null) {
                queue.add(item.next);
            }
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