package leet_code.leet_code_0051_0100.leet_code_0061;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode last = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        last.next = head;
        k %= len;

        ListNode node = head;
        int index = len - k - 1;
        while (index-- > 0) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}