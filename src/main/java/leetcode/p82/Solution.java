package leetcode.p82;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode pre = null;
        while (head != null) {
            if (pre == null) {
                pre = head;
                head = head.next;
            } else if (pre.val == head.val) {
                while (head != null && head.val == pre.val) {
                    head = head.next;
                }
                pre = null;
            } else {
                pre.next = null;
                tail.next = pre;
                tail = tail.next;
                pre = head;
                head = head.next;
            }
        }

        if (pre != null) {
            pre.next = null;
            tail.next = pre;
        }

        return dummy.next;
    }
}
