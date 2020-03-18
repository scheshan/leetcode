package l24;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = swapPairs(head.next.next);

        ListNode next = head.next;
        next.next = head;
        head.next = n;

        return next;
    }
}
