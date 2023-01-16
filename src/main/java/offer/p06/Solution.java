package offer.p06;

import common.ListNode;

import java.util.ArrayList;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        ListNode h = null;
        int cnt = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = h;
            h = head;

            head = next;
            cnt++;
        }

        int[] res = new int[cnt];
        int ind = 0;
        while (h != null) {
            res[ind] = h.val;
            h = h.next;
            ind++;
        }

        return res;
    }
}
