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

        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;

        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = head;
            } else {
                rightTail.next = head;
                rightTail = head;
            }

            head = head.next;
        }

        leftTail.next = rightHead.next;
        rightTail.next = null;

        return leftHead.next;
    }

    public static void main(String[] args) {
        new Solution().partition(new ListNode(1), 1);
    }
}
