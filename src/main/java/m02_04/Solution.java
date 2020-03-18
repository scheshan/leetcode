package m02_04;

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
        ListNode xHead = null;
        ListNode xTail = null;

        while (head != null) {
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = head;
                }
            } else if (head.val > x) {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = head;
                }
            } else {
                if (xHead == null) {
                    xHead = head;
                    xTail = head;
                } else {
                    xTail.next = head;
                    xTail = head;
                }
            }

            head = head.next;
        }

        if (leftHead == null) {
            leftHead = rightHead;
            leftTail = rightTail;
        } else {
            leftTail.next = rightHead;
            leftTail = rightTail != null ? rightTail : leftTail;
        }

        if (leftHead == null) {
            leftHead = xHead;
        } else {
            leftTail.next = xHead;
        }

        if (xTail != null) {
            xTail.next = null;
        }

        return leftHead;
    }

    public static void main(String[] args) {
        new Solution().partition(new ListNode(1), 1);
    }
}
