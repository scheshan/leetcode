package leetcode.p23;

import common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/19
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.val, o2.val);
        });

        if (lists != null) {
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            ListNode next = node.next;

            tail.next = node;
            tail = node;
            node.next = null;

            if (next != null) {
                queue.add(next);
            }
        }

        return dummy.next;
    }
}
