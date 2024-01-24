package leetcode.p147;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            res = sort(res, head);
            head = next;
        }

        return res;
    }

    private ListNode sort(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b.val < a.val) {
            b.next = a;
            return b;
        }

        ListNode cur = a;
        while (cur.next != null && cur.next.val < b.val) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = b;
        b.next = next;
        return a;
    }
}
