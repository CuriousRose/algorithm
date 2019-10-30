package leet_code.leet_code_0001_0050.leet_code_0002;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = l1.val + l2.val;

        ListNode node = new ListNode(s % 10);
        ListNode head = node;

        int m = s / 10;

        while (l1.next != null || l2.next != null || m > 0) {
            s = m;

            if (l1.next != null) {
                l1 = l1.next;
                s += l1.val;
            }

            if (l2.next != null) {
                l2 = l2.next;
                s += l2.val;
            }

            node.next = new ListNode(s % 10);
            node = node.next;
            m = s / 10;
        }

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