package lcr.p142;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int n2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            ListNode selected = null;
            if (n1 < n2) {
                selected = l1;
                l1 = l1.next;
            } else {
                selected = l2;
                l2 = l2.next;
            }
            selected.next = null;
            tail.next = selected;
            tail = tail.next;
        }

        return dummy.next;
    }
}
