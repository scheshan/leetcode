package m18;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return deleteNode(head.next, val);
        }

        head.next = deleteNode(head.next, val);
        return head;
    }
}
