package leetcode.p2095;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        ListNode pre = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return null;
        }

        pre.next = pre.next.next;
        return head;
    }
}
