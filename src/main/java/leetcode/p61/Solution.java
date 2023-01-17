package leetcode.p61;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int total = 0;
        ListNode node = head;
        ListNode tail = null;
        while (node != null) {
            total++;
            tail = node;
            node = node.next;
        }

        k = total - (k % total);
        if (k == total) {
            return head;
        }

        ListNode pre = null;
        node = head;
        for (int i = 0; i < k; i++) {
            pre = node;
            node = node.next;
        }

        if (pre != null) {
            pre.next = null;
            tail.next = head;
            return node;
        }
        return head;
    }
}
