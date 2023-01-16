package leetcode.p24;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            ListNode a = head;
            ListNode b = a.next;
            a.next = null;

            if (b == null) {
                tail.next = a;
                break;
            } else {
                ListNode next = b.next;
                b.next = null;
                tail.next = b;
                tail = tail.next;
                tail.next = a;
                tail = tail.next;

                head = next;
            }
        }

        return dummy.next;
    }
}
