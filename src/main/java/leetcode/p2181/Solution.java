package leetcode.p2181;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val == 0) {
                if (pre != null) {
                    tail.next = pre;
                    tail = tail.next;
                    pre = null;
                }
            } else {
                if (pre == null) {
                    pre = head;
                } else {
                    pre.val += head.val;
                }
            }

            head = next;
        }

        return dummy.next;
    }
}
