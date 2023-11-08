package leetcode.p86;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/8
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode tail1 = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode tail2 = dummy2;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (head.val < x) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }

            head = next;
        }

        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
