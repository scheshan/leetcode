package leetcode.p24;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            if (next != null) {
                int t = next.val;
                next.val = cur.val;
                cur.val = t;

                cur = next.next;
            } else {
                cur = next;
            }
        }

        return head;
    }
}
