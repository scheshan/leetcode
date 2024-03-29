package leetcode.p143;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;

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

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null && right != null) {
            ListNode n1 = head.next;
            ListNode n2 = right.next;

            tail.next = head;
            tail = tail.next;
            tail.next = right;
            tail = tail.next;

            head = n1;
            right = n2;
        }
        tail.next = head;
    }
}
