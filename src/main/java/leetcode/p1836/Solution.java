package leetcode.p1836;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        int[] cnt = new int[100001];

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            cnt[head.val]++;
            if (cnt[head.val] == 1) {
                tail.next = head;
                tail = tail.next;
            }

            head = next;
        }

        ListNode res = new ListNode();
        tail = res;
        head = dummy.next;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;

            if (cnt[head.val] == 1) {
                tail.next = head;
                tail = tail.next;
            }

            head = next;
        }

        return res.next;
    }
}
