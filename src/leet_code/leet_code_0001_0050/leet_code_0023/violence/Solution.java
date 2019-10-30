package leet_code.leet_code_0001_0050.leet_code_0023.violence;

class Solution {
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

        ListNode node = new ListNode(0);
        ListNode head = node;

        while (node != null) {
            ListNode item = null;
            int index = -1;

            for (int i = 0; i < lists.length; i++) {
                ListNode listNode = lists[i];

                if (listNode == null) {
                    continue;
                }

                if (item == null || listNode.val < item.val) {
                    item = listNode;
                    index = i;
                }
            }

            if (item == null) {
                break;
            } else {
                node.next = item;
                item = item.next;
                lists[index] = item;
                node = node.next;
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