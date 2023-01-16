package leetcode.p83;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int pre = Integer.MAX_VALUE;
        while (head != null) {
            ListNode next = head.next;
            int v = head.val;
            if (v != pre) {
                head.next = null;
                tail.next = head;
                tail = head;
            }
            pre = v;
            head = next;
        }

        return dummy.next;
    }
}
