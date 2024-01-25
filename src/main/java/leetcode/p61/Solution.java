package leetcode.p61;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }

        k = k % cnt;
        if (k == 0) {
            return head;
        }

        ListNode res = head;
        ListNode pre = null;
        for (int i = 0; i < cnt - k; i++) {
            pre = res;
            res = res.next;
        }

        if (pre != null) {
            pre.next = null;
        }

        cur = res;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        return res;
    }
}
