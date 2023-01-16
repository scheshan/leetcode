package leetcode.p23;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        merge(lists, 0, lists.length - 1);
        return lists[0];
    }

    private void merge(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >> 1);
        merge(lists, left, mid);
        merge(lists, mid + 1, right);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode l1 = lists[left];
        ListNode l2 = lists[mid + 1];

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1;
        if (l2 != null) {
            tail.next = l2;
        }
        lists[left] = dummy.next;
    }
}
