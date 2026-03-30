package interview.p02_04;

import common.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode();
        ListNode t1 = h1;

        ListNode h2 = new ListNode();
        ListNode t2 = h2;

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

        t1.next = h2.next;
        return h1.next;
    }
}
