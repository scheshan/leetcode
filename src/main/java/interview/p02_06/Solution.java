package interview.p02_06;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/17
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre == null) {
            return true;
        }

        ListNode cur = pre.next, h2 = null;
        pre.next = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = h2;
            h2 = cur;
            cur = next;
        }

        while (head != null) {
            if (head.val != h2.val) {
                return false;
            }
            head = head.next;
            h2 = h2.next;
        }

        return true;
    }
}
