package leetcode.p2487;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            while (!deque.isEmpty() && deque.peekLast().val < head.val) {
                deque.removeLast();
            }
            if (!deque.isEmpty()) {
                deque.peekLast().next = head;
            }
            deque.addLast(head);
            head = next;
        }

        if (deque.isEmpty()) {
            return null;
        }

        return deque.peekFirst();
    }
}
