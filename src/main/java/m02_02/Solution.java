package m02_02;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public int kthToLast(ListNode head, int k) {
        ListNode low = head, fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.val;
    }
}
