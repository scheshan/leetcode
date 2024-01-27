package leetcode.p92;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            ListNode next = cur.next;
            cur.next = null;
            tail.next = cur;
            tail = tail.next;
            cur = next;
        }

        ListNode h2 = null;
        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = h2;
            h2 = cur;
            cur = next;
        }

        tail.next = h2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = cur;

        return dummy.next;
    }
}
