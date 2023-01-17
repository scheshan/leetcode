package leetcode.p2046;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public ListNode sortLinkedList(ListNode head) {
        ListNode d1 = null;
        ListNode t1 = null;
        ListNode d2 = null;
        ListNode t2 = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val < 0) {
                if (d1 == null) {
                    t1 = head;
                } else {
                    head.next = d1;
                }
                d1 = head;
            } else {
                if (d2 == null) {
                    d2 = head;
                } else {
                    t2.next = head;
                }
                t2 = head;
            }

            head = next;
        }

        if (d1 == null) {
            return d2;
        }

        t1.next = d2;
        return d1;
    }
}
