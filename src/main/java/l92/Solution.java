package l92;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        return reverse(head, 1, m, n);
    }

    private ListNode reverse(ListNode head, int i, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (i < m || i >= n) {
            head.next = reverse(head.next, i + 1, m, n);
            return head;
        } else {
            ListNode newHead = reverse(head.next, i + 1, m, n);
            ListNode next = head.next;

            head.next = next.next;
            next.next = head;
            return newHead;
        }
    }
}
