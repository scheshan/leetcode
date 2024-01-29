package interview.p02_03;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
