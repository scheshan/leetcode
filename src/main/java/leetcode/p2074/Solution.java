package leetcode.p2074;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int cnt = 0;
        while (head != null) {
            cnt++;
            int i = 0;
            ListNode pre = null;
            ListNode h = head;
            for (; i < cnt && h != null; i++) {
                pre = h;
                h = h.next;
            }
            pre.next = null;

            if ((i & 1) == 1) {
                tail.next = head;
                tail = pre;
            } else {
                tail.next = reverse(head);
                tail = head;
            }

            head = h;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }
}
