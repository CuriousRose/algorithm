package leet_code.leet_code_0001_0050.leet_code_0021;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode node = solution.mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;

        if (l1 == null && l2 == null) {
            return null;
        }

        while (l1 != null || l2 != null) {
            if (l2 == null) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
                continue;
            }

            if (l1 == null) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
                continue;
            }

            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
                continue;
            }

            if (l1.val >= l2.val) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
                continue;
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