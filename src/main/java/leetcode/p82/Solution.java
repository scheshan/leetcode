package leetcode.p82;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/20
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                tail.next = head;
                tail = head;
                head = head.next;
                tail.next = null;
            } else {
                ListNode node = head;
                while (head != null && head.val == node.val) {
                    head = head.next;
                }
            }
        }

        return dummy.next;
    }
}
