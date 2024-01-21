package leetcode.p328;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1 = new ListNode();
        ListNode tail1 = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode tail2 = dummy2;

        int cur = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if ((cur & 1) == 0) {
                tail1.next = head;
                tail1 = head;
            } else {
                tail2.next = head;
                tail2 = head;
            }
            head = next;
            cur++;
        }

        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
