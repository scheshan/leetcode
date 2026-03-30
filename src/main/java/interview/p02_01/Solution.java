package interview.p02_01;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Set<Integer> visit = new HashSet<>();

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (!visit.contains(head.val)) {
                visit.add(head.val);
                tail.next = head;
                tail = tail.next;
            }
            head = next;
        }

        return dummy.next;
    }
}
