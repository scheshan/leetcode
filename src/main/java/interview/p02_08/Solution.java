package interview.p02_08;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
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
