package leetcode.p234;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
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

        while (head != null && right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }

        return head == null || head.next == null;
    }
}
