package leetcode.p1836;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            count.compute(node.val, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        node = head;

        while (node != null) {
            ListNode next = node.next;
            if (count.get(node.val) == 1) {
                tail.next = node;
                tail = node;
                tail.next = null;
            }

            node = next;
        }

        return dummy.next;
    }
}
