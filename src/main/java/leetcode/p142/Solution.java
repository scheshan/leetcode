package leetcode.p142;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (head != null && head.next != null) {
            head = head.next.next;
            slow = slow.next;

            if (head == slow) {
                break;
            }
        }

        if (head == null || head.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
