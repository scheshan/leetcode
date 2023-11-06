package leetcode.p2181;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/6
 */
public class Solution {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode cur = new ListNode();
        while (head != null) {
            if (head.val == 0) {
                if (cur.val != 0) {
                    tail.next = cur;
                    tail = tail.next;
                    cur = new ListNode();
                }
            } else {
                cur.val += head.val;
            }
            head = head.next;
        }

        if (cur.val != 0) {
            tail.next = cur;
        }
        return dummy.next;
    }
}
