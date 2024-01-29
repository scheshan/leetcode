package lcr.p141;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode trainningPlan(ListNode head) {
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
