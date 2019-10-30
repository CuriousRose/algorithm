package leet_code.leet_code_0051_0100.leet_code_0083;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode index = new ListNode(0);
        head = index;
        while (node.next != null) {
            ListNode next = node.next;
            if (node.val == next.val) {
                node = next;
            } else {
                index.next = node;
                index = index.next;
                node = next;
            }
        }
        index.next = node;
        node.next = null;
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