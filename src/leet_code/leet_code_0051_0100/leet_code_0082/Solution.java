package leet_code.leet_code_0051_0100.leet_code_0082;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(5);
        head = solution.deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        int record = head.val;
        int count = 1;
        ListNode node = head;
        ListNode index = new ListNode(0);
        head = index;
        while (node.next != null) {
            ListNode next = node.next;
            if (next.val == record) {
                count++;
                node = next;
            } else {
                if (count == 1) {
                    index.next = node;
                    index = index.next;
                } else {
                    count = 1;
                }
                record = next.val;
                node = next;
            }
        }
        if (count == 1) {
            index.next = node;
            index = index.next;
        }
        index.next = null;
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