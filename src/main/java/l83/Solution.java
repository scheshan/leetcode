package l83;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        return travel(head, null);
    }

    private ListNode travel(ListNode node, Integer prev) {
        if (node == null) {
            return null;
        }

        if (prev != null && node.val == prev) {
            return travel(node.next, prev);
        } else {
            node.next = travel(node.next, node.val);
            return node;
        }
    }
}
