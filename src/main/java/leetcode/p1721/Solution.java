package leetcode.p1721;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode first = null;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        first = fast;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int value = slow.val;
        slow.val = first.val;
        first.val = value;

        return head;
    }
}
