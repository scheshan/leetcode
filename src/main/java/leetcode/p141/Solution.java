package leetcode.p141;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        return fast != null;
    }
}
