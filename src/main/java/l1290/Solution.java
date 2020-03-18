package l1290;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = (result << 1) + head.val;
            head = head.next;
        }

        return result;
    }
}
