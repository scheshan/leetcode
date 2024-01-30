package leetcode.p19;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head, pre = null;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
