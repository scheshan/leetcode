package m02_01;

import shared.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        travel(head, new HashSet<>());
        return head;
    }

    private ListNode travel(ListNode node, Set<Integer> set) {
        if (node == null) {
            return null;
        }

        if (set.contains(node.val)) {
            return travel(node.next, set);
        } else {
            set.add(node.val);

            node.next = travel(node.next, set);

            return node;
        }
    }
}
