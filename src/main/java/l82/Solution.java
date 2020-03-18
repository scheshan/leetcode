package l82;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head.next = deleteDuplicates(head.next);

            if (head.next != null && head.val == head.next.val) {
                return head.next.next;
            } else {
                return head.next;
            }
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
