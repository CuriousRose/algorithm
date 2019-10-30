package leet_code.leet_code_0001_0050.leet_code_0024;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        listNode = solution.swapPairs(listNode);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        node.next = head;
        head = node;


        while (node.next != null && node.next.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = node.next.next;
            node.next.next = next;
            node = next;
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