package leetcode.p83;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/7
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (tail.val != head.val) {
                tail.next = head;
                tail = tail.next;
            }

            head = next;
        }

        return dummy.next;
    }
}
