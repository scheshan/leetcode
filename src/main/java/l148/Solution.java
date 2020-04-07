package l148;

import shared.ListNode;
import shared.Wrapper;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = middle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        while (left != null) {
            cur.next = left;
            cur = cur.next;
            left = left.next;
        }
        while (right != null) {
            cur.next = right;
            cur = cur.next;
            right = right.next;
        }

        cur.next = null;
        return dummy.next;
    }

    private ListNode middle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (fast != null) {
            prev = slow;

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = Wrapper.stringToListNode("[4,2,1,3]");

        ListNode res = new Solution().sortList(head);
    }
}
