package l141;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode low = head;
        ListNode fast = head.next;

        while (low != fast) {
            if (low != null) {
                low = low.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
            if (fast != null) {
                fast = fast.next;
            }
        }

        return low != null;
    }
}
