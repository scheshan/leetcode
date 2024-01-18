package leetcode.p2807;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/19
 */
public class Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode tail = null, cur = head;

        while (cur != null) {
            if (tail == null) {
                tail = cur;
            } else {
                int v = gcd(tail.val, cur.val);

                ListNode n = new ListNode();
                n.val = v;
                tail.next = n;
                n.next = cur;
                tail = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }
}
