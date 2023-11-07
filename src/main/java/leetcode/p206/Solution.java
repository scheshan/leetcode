package leetcode.p206;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/8
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode res = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;

            head = next;
        }

        return res;
    }
}
