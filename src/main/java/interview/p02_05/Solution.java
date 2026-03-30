package interview.p02_05;

import common.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        boolean flag = false;

        while (l1 != null || l2 != null || flag) {
            int sum = flag ? 1 : 0;
            flag = false;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                sum -= 10;
                flag = true;
            }

            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        return dummy.next;
    }
}
