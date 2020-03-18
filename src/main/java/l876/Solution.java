package l876;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode low = head;
        ListNode fast = head.next;

        while (fast != null) {
            low = low.next;

            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return low.next;
    }
}
