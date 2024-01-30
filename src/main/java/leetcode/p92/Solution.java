package leetcode.p92;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (int i = 1; i < left; i++) {
            ListNode next = head.next;
            head.next = null;

            tail.next = head;
            tail = tail.next;

            head = next;
        }

        ListNode tail2 = head;
        ListNode head2 = null;
        for (int i = left; i <= right; i++) {
            ListNode next = head.next;
            head.next = head2;
            head2 = head;

            head = next;
        }

        tail.next = head2;
        tail2.next = head;

        return dummy.next;
    }
}
