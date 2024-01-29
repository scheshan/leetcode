package leetcode.p2487;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;

        Deque<ListNode> deque = new LinkedList<>();
        deque.addLast(tail);

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            while (!deque.isEmpty() && deque.peekLast().val < head.val) {
                deque.removeLast();
                tail = deque.peekLast();
                tail.next = null;
            }
            deque.addLast(head);
            tail.next = head;
            tail = tail.next;
            head = next;
        }

        return dummy.next;
    }
}
