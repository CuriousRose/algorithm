package leet_code.leet_code_0201_0250.leet_code_0234;

import java.util.LinkedList;

/**
 * @author chj
 * @date 2019/7/1 11:45
 * 链表
 * 11:51
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.addLast(head.val);
            head = head.next;
        }
        while (linkedList.size() >= 2) {
            int a = linkedList.removeFirst();
            int b = linkedList.removeLast();
            if (a != b) {
                return false;
            }
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}