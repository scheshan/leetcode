package leetcode.p21;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null || list2 != null) {
            int n1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int n2 = list2 == null ? Integer.MAX_VALUE : list2.val;

            ListNode selected = null;
            if (n1 < n2) {
                selected = list1;
                list1 = list1.next;
            } else {
                selected = list2;
                list2 = list2.next;
            }
            selected.next = null;
            tail.next = selected;
            tail = tail.next;
        }

        return dummy.next;
    }
}
