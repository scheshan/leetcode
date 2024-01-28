package leetcode.p2130;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int pairSum(ListNode head) {
        int res = Integer.MIN_VALUE;

        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2;
        if (pre != null) {
            pre.next = null;
            l2 = reverse(slow);
        } else {
            l2 = reverse(l1.next);
            l1.next = null;
        }

        while (l1 != null && l2 != null) {
            int n = l1.val + l2.val;
            res = Math.max(n, res);
            l1 = l1.next;
            l2 = l2.next;
        }

        return res;
    }

    private ListNode reverse(ListNode node) {
        ListNode res = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }
}
