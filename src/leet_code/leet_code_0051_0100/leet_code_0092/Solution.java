package leet_code.leet_code_0051_0100.leet_code_0092;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        node = solution.reverseBetween(node, 1, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        ListNode left = node;
        ListNode right = node;
        ListNode result = node;
        result.next = head;
        node.next = head;
        int index = 0;
        while (node != null) {
            if (index == m - 1) {
                left = node;
            }
            if (index == n) {
                right = node.next;
            }
            node = node.next;
            index++;
        }
        node = left.next;
        head = node;
        ListNode next = node.next;
        for (int i = m; i < n; i++) {
            ListNode record = next.next;
            next.next = node;
            node = next;
            next = record;
        }
        left.next = node;
        head.next = right;
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}