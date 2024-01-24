package leetcode.p148;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l1 = head;
        ListNode l2 = split(l1);

        l1 = sortList(l1);
        l2 = sortList(l2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (v1 < v2) {
                ListNode next = l1.next;
                l1.next = null;
                tail.next = l1;
                l1 = next;
            } else {
                ListNode next = l2.next;
                l2.next = null;
                tail.next = l2;
                l2 = next;
            }
            tail = tail.next;
        }

        return dummy.next;
    }

    private ListNode split(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }
}
