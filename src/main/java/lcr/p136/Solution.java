package lcr.p136;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(), tail = dummy;

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
