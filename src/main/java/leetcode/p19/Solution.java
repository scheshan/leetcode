package leetcode.p19;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/7
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if(pre == null) {
            return head.next;
        }

        pre.next = slow.next;
        return head;
    }
}
