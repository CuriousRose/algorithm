package leet_code.leet_code_0101_0150.leet_code_0147;

/**
 * 链表 排序
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode next = head.next;
            ListNode node = result;
            while (node != null && node.val < head.val) {
                if (node.next == null || node.next.val > head.val) {
                    break;
                }
                node = node.next;
            }
            head.next = node.next;
            node.next = head;
            head = next;
        }
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