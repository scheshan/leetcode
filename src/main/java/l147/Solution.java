package l147;

import shared.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        ListNode next = head;

        while (next != null) {
            ListNode t = next;
            next = next.next;

            res = sort(res, t);
        }

        return res;
    }

    private ListNode sort(ListNode head, ListNode node) {
        if (head == null) {
            node.next = null;
            return node;
        }

        head.next = sort(head.next, node);

        if(head.next != null && head.next.val < head.val) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            return next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        new Solution().insertionSortList(head);
    }
}
