package leetcode.p2130;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = null;
        ListNode node = slow.next;
        slow.next = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = right;
            right = node;
            node = next;
        }

        int res = 0;
        while (head != null && right != null) {
            res = Math.max(res, head.val + right.val);
            head = head.next;
            right = right.next;
        }

        return res;
    }
}
