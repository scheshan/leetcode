package leetcode.p2;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        boolean flag = false;
        while (l1 != null && l2 != null) {
            int n = l1.val + l2.val;
            if (flag) {
                n++;
                flag = false;
            }

            if (n >= 10) {
                flag = true;
                n -= 10;
            }

            tail.next = new ListNode(n);
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (flag || l1 != null || l2 != null) {
            int n = 0;
            if (flag) {
                n++;
                flag = false;
            }
            if (l1 != null) {
                n += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }

            if (n >= 10) {
                flag = true;
                n -= 10;
            }

            tail.next = new ListNode(n);
            tail = tail.next;
        }

        return dummy.next;
    }
}
