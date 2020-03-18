package l203;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements(head.next, val);
        }

        head.next = removeElements(head.next, val);
        return head;
    }
}
