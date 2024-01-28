package leetcode.p328;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode d1 = new ListNode(), d2 = new ListNode();
        ListNode t1 = d1, t2 = d2;

        int ind = 1;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if ((ind & 1) == 1) {
                t1.next = head;
                t1 = t1.next;
            } else {
                t2.next = head;
                t2 = t2.next;
            }
            ind = 1 - ind;
            head = next;
        }

        t1.next = d2.next;
        return d1.next;
    }
}
