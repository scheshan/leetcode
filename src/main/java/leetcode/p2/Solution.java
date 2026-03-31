package leetcode.p2;

import common.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        boolean flag = false;

        while (l1 != null || l2 != null || flag) {
            int n = flag ? 1 : 0;
            flag = false;
            if (l1 != null) {
                n += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }
            if (n >= 10) {
                n -= 10;
                flag = true;
            }
            tail.next = new ListNode(n);
            tail = tail.next;
        }

        return dummy.next;
    }
}
