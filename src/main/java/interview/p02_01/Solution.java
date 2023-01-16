package interview.p02_01;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (!set.contains(head.val)) {
                set.add(head.val);
                tail.next = head;
                tail = head;
            }

            head = next;
        }

        return dummy.next;
    }
}
