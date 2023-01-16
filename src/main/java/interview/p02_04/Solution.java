package interview.p02_04;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode t1 = d1;
        ListNode d2 = new ListNode(0);
        ListNode t2 = d2;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val < x) {
                t1.next = head;
                t1 = head;
            } else {
                t2.next = head;
                t2 = head;
            }
            head = next;
        }

        t1.next = d2.next;
        return d1.next;
    }
}
