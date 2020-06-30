package l1474;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/6/30
 */
public class Solution {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        return delete(head, 0, m, n);
    }

    private ListNode delete(ListNode head, int cur, int m, int n) {
        if (cur >= m + n) {
            cur = 0;
        }
        if (head == null) {
            return null;
        }

        ListNode next = delete(head.next, cur + 1, m, n);
        if (cur >= m) {
            return next;
        } else {
            head.next = next;
            return head;
        }
    }
}
