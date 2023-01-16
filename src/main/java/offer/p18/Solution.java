package offer.p18;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val != val) {
                tail.next = head;
                tail = tail.next;
            }
            head = next;
        }

        return dummy.next;
    }
}
