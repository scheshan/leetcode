package leetcode.p83;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val != tail.val) {
                tail.next = head;
                tail = tail.next;
            }

            head = next;
        }

        return dummy.next;
    }
}
