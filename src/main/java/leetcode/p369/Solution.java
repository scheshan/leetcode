package leetcode.p369;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public ListNode plusOne(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }

        ListNode res = null;
        boolean flag = true;
        while (node != null || flag) {
            int n = 0;
            if (flag) {
                n++;
                flag = false;
            }
            ListNode next = null;
            if (node != null) {
                next = node.next;
                node.val += n;
                if (node.val >= 10) {
                    node.val -= 10;
                    flag = true;
                }
            } else {
                node = new ListNode(n);
            }
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }
}
