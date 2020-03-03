package l19;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/3
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode low = head, fast = head;

        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head.next;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        new Solution().removeNthFromEnd(head, 1);
    }
}
