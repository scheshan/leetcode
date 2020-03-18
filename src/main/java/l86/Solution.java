package l86;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;

        while (head != null) {
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = head;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = head;
                }
            }

            head = head.next;
        }

        if (leftHead == null) {
            leftHead = rightHead;
        } else {
            leftTail.next = rightHead;
        }
        if (rightTail != null) {
            rightTail.next = null;
        }

        return leftHead;
    }
}
