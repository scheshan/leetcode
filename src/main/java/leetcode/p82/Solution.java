package leetcode.p82;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                ListNode fast = head.next;
                while (fast != null && fast.val == head.val) {
                    fast = fast.next;
                }
                head = fast;
            } else {
                ListNode next = head.next;
                head.next = null;
                tail.next = head;
                tail = head;
                head = next;
            }
        }

        return dummy.next;
    }
}
