package leet_code.leet_code_0151_0200.leet_code_0160;

import java.util.Stack;

/**
 * 链表
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (headA != null) {
            stack1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stack2.push(headB);
            headB = headB.next;
        }

        ListNode node = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            node = stack1.pop();
            stack2.pop();
        }
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}