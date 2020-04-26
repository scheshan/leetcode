package l23;

import shared.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            ListNode next = node.next;

            tail.next = node;
            node.next = null;
            tail = node;

            if (next != null) {
                queue.add(next);
            }
        }

        tail.next = null;
        return dummy.next;
    }
}
