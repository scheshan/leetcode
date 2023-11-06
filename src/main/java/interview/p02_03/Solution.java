package interview.p02_03;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/6
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
