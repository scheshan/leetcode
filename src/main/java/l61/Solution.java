package l61;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }

        int total = 0;

        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            total++;

            tail = cur;
            cur = cur.next;
        }
        tail.next = head;

        k = k % total;
        int n = total - k;

        cur = head;
        for (int i = 1; i < n; i++) {
            cur = cur.next;
        }

        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
