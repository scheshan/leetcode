package interview.p02_07;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            if (l1 == null) {
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }

        return l1;
    }
}
