package leet_code.leet_code_0001_0050.leet_code_0023.division;

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
        return division(lists, 0, lists.length - 1);
    }

    ListNode division(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (r - l == 1) {
            return mergeTwoLists(lists[l], lists[r]);
        }
        int m = (l + r) / 2;
        ListNode l1 = division(lists, l, m);
        ListNode l2 = division(lists, m + 1, r);
        return mergeTwoLists(l1, l2);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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