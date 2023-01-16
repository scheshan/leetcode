package offer2.p021;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            ListNode next = slow.next;
            slow.next = null;

            tail.next = slow;
            tail = tail.next;

            fast = fast.next;
            slow = next;
        }

        slow = slow.next;

        while (slow != null) {
            tail.next = slow;
            tail = tail.next;
            slow = slow.next;
        }

        return dummy.next;
    }
}
