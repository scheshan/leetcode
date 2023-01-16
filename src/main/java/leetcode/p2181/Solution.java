package leetcode.p2181;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            boolean has = false;
            int cnt = 0;
            while (head != null && head.val != 0) {
                has = true;
                cnt += head.val;
                head = head.next;
            }

            if (has) {
                tail.next = new ListNode(cnt);
                tail = tail.next;
            }

            while (head != null && head.val == 0) {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
