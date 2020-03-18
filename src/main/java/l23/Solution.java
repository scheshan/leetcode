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
        if (lists.length == 0) {
            return null;
        }

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

        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            if (node.next != null) {
                queue.add(node.next);
            }
        }

        if (tail != null) {
            tail.next = null;
        }
        return head;
    }
}
