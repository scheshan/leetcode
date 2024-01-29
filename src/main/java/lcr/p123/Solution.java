package lcr.p123;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int[] reverseBookList(ListNode head) {
        int total = 0;
        ListNode cur = head;

        while (cur != null) {
            total++;
            cur = cur.next;
        }

        int[] res = new int[total];
        int ind = res.length - 1;
        while (head != null) {
            res[ind--] = head.val;
            head = head.next;
        }

        return res;
    }
}
