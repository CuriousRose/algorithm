package leet_code.leet_code_0201_0250.leet_code_0237;

/**
 * @author chj
 * @date 2019/7/4 10:15
 * 链表
 * 10:24
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}