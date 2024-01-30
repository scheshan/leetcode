package leetcode.p86;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(), d2 = new ListNode();
        ListNode t1 = d1, t2 = d2;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val < x) {
                t1.next = head;
                t1 = t1.next;
            } else {
                t2.next = head;
                t2 = t2.next;
            }

            head = next;
        }

        t1.next = d2.next;
        return d1.next;
    }
}
