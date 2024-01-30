package leetcode.p234;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return true;
        }

        ListNode cur = pre.next;
        pre.next = null;

        ListNode h2 = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = h2;
            h2 = cur;
            cur = next;
        }

        while (head != null && h2 != null) {
            if (head.val != h2.val) {
                return false;
            }
            head = head.next;
            h2 = h2.next;
        }
        return true;
    }
}
