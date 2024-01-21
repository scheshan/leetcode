package leetcode.p141;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
