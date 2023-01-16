package leetcode.p1669;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < a; i++) {
            ListNode next = list1.next;

            tail.next = list1;
            tail = tail.next;
            list1.next = null;

            list1 = next;
        }

        for (int i = a; i <= b; i++) {
            list1 = list1.next;
        }

        while (list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }

        while (list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }

        return dummy.next;
    }
}
