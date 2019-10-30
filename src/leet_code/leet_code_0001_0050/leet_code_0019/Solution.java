package leet_code.leet_code_0001_0050.leet_code_0019;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            node = node.next;
            len++;
        }

        node = head;
        if (len == n) {
            return head.next;
        }
        for (int i = 0; i < len - n - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
