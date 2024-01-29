package leetcode.p2807;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            tail.next = head;
            tail = tail.next;
            if (next != null) {
                ListNode node = new ListNode(gcd(head.val, next.val));
                tail.next = node;
                tail = tail.next;
            }

            head = next;
        }

        return dummy.next;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
