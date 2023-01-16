package leetcode.p725;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode node = head;
        int total = 0;
        while (node != null) {
            total++;
            node = node.next;
        }

        int mod = total % k;
        int cnt = total / k;

        ListNode[] res = new ListNode[k];

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < k; i++) {
            int cn = cnt;
            if (mod > 0) {
                mod--;
                cn++;
            }
            for (int j = 0; j < cn; j++) {
                tail.next = head;
                tail = head;
                head = head.next;
            }

            tail.next = null;
            res[i] = dummy.next;
            dummy.next = null;
            tail = dummy;
        }

        return res;
    }
}
