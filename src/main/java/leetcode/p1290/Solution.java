package leetcode.p1290;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res = res | head.val;
            head = head.next;
        }
        return res;
    }
}
