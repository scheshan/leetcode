package lcr.p140;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
