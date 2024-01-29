package leetcode.p1474;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            int i = 0;
            while (head != null && i < m) {
                tail.next = head;
                tail = tail.next;
                head = head.next;
                i++;
            }

            tail.next = null;
            i = 0;
            while (head != null && i < n) {
                head = head.next;
                i++;
            }
        }

        return dummy.next;
    }
}
