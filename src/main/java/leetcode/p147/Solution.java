package leetcode.p147;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        ListNode res = null;

        while (head != null) {
            ListNode next = head.next;
            if (res == null || head.val < res.val) {
                head.next = res;
                res = head;
            } else {
                ListNode pre = res;
                ListNode node = res.next;

                while (node != null) {
                    if (head.val < node.val) {
                        pre.next = head;
                        head.next = node;
                        break;
                    }
                    pre = node;
                    node = node.next;
                }
                if (node == null) {
                    pre.next = head;
                    head.next = null;
                }
            }
            head = next;
        }

        return res;
    }
}
