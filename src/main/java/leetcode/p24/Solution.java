package leetcode.p24;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/7
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            ListNode l1 = head;
            ListNode l2 = l1.next;

            if (l2 != null) {
                head = l2.next;
            } else {
                head = null;
            }

            if (l2 != null) {
                l2.next = null;
                tail.next = l2;
                tail = tail.next;
            }
            l1.next = null;
            tail.next = l1;
            tail = tail.next;
        }

        return dummy.next;
    }
}
