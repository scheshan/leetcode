package leetcode.p148;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head, right = null;
        if (pre != null) {
            right = pre.next;
            pre.next = null;
        }

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), tail = dummy;

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int v2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (v1 < v2) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        return dummy.next;
    }
}
