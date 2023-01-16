package leetcode.p92;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 1; i < left; i++) {
            ListNode next = head.next;
            head.next = null;
            tail.next = head;
            tail = head;
            head = next;
        }

        ListNode midHead = null;
        ListNode midTail = null;
        for (int i = left; i <= right; i++) {
            ListNode next = head.next;

            if (midHead == null) {
                midTail = head;
            }
            head.next = midHead;
            midHead = head;
            head = next;
        }

        tail.next = midHead;
        if (midTail != null) {
            midTail.next = head;
        }

        return dummy.next;
    }
}
