package offer2.p025;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        boolean flag = false;
        while (l1 != null || l2 != null || flag) {
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
                n -= 10;
                flag = true;
            }

            ListNode node = new ListNode(n);
            tail.next = node;
            tail = node;
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }

        return res;
    }
}
