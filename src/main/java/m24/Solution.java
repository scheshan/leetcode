package m24;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return next;
    }
}
