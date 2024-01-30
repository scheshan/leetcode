package leetcode.p2;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        boolean flag = false;
        while (l1 != null || l2 != null || flag) {
            ListNode node = new ListNode();
            if (flag) {
                node.val++;
                flag = false;
            }

            if (l1 != null) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            }
            if (node.val >= 10) {
                node.val -= 10;
                flag = true;
            }
            tail.next = node;
            tail = tail.next;
        }

        return dummy.next;
    }
}
