package l142;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode low = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            low = low.next;

            if (fast == low) {
                break;
            }
        }

        if (low == null) {
            return null;
        }

        low = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }

        return low;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        new Solution().detectCycle(head);
    }
}
