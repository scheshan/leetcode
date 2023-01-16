package leetcode.p2095;

import common.ListNode;

/**
 * main
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return null;
        } else {
            pre.next = slow.next;
            return head;
        }
    }
}
