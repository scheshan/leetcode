package leetcode.p203;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/18
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val != val) {
                tail.next = head;
                tail = head;
            }

            head = next;
        }

        return dummy.next;
    }
}
