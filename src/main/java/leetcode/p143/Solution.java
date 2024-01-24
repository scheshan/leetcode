package leetcode.p143;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = reverse(split(left));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (left != null) {
            tail.next = left;
            left = left.next;
            tail = tail.next;

            if (right != null) {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = res;
            res = head;
            head = next;
        }

        return res;
    }

    private ListNode split(ListNode head) {
        ListNode pre = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre != null) {
            pre.next = null;
            return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        new Solution().reorderList(new ListNode(1));
    }
}
