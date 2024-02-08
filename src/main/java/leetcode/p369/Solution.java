package leetcode.p369;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/8
 */
public class Solution {

    public ListNode plusOne(ListNode head) {
        boolean b = plus(head);
        if (b) {
            ListNode res = new ListNode(1);
            res.next = head;
            return res;
        }
        return head;
    }

    private boolean plus(ListNode node) {
        boolean b = node.next == null ? true : plus(node.next);

        if (b) {
            node.val++;
            if (node.val >= 10) {
                node.val -= 10;
                return true;
            }
        }

        return false;
    }
}
