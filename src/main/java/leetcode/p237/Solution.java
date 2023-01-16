package leetcode.p237;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
