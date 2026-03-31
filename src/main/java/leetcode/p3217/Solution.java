package leetcode.p3217;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> visit = new HashSet<>(nums.length, 1);
        for (int num : nums) {
            visit.add(num);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            if (!visit.contains(head.val)) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }

        tail.next = null;
        return dummy.next;
    }
}
