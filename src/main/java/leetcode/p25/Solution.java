package leetcode.p25;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(), tail = dummy;

        ListNode cur = head;
        while (cur != null) {
            int ind = 0;
            ListNode h = null;

            while (ind < k && cur != null) {
                ListNode next = cur.next;
                cur.next = h;
                h = cur;
                cur = next;
                ind++;
            }

            if (ind < k) {
                ListNode h2 = null;
                while (h != null) {
                    ListNode next = h.next;
                    h.next = h2;
                    h2 = h;
                    h = next;
                }
                tail.next = h2;
                break;
            }

            tail.next = h;
            while (tail.next != null) {
                tail = tail.next;
            }
        }

        return dummy.next;
    }
}
