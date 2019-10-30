package leet_code.leet_code_0051_0100.leet_code_0086;

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                l1.next = node;
                l1 = l1.next;
            } else {
                l2.next = node;
                l2 = l2.next;
            }
            node = node.next;
        }
        l1.next = h2.next;
        l2.next = null;
        return h1.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}