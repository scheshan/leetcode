package leetcode.p2058;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = null;
        int firstInd = -1;
        int preInd = -1;
        int ind = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (head != null) {
            ind++;
            ListNode next = head.next;
            if (pre != null
                    && next != null
                    && (head.val > pre.val && head.val > next.val || (head.val < pre.val && head.val < next.val))
            ) {
                if (preInd < 0) {
                    firstInd = ind;
                } else {
                    min = Math.min(min, ind - preInd);
                    max = Math.max(max, ind - firstInd);
                }
                preInd = ind;
            }
            pre = head;
            head = next;
        }
        return min == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{min, max};
    }
}
