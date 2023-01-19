package leetcode.p25;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            ListNode tmp = null;
            ListNode tmpTail = null;

            int cnt = 0;
            while (cnt < k && head != null) {
                cnt++;
                ListNode next = head.next;
                head.next = tmp;
                if (tmpTail == null) {
                    tmpTail = head;
                }
                tmp = head;
                head = next;
            }

            if (cnt == k) {
                tail.next = tmp;
                tail = tmpTail;
            } else {
                tail.next = reverseKGroup(tmp, cnt);
            }
        }
        return dummy.next;
    }
}
