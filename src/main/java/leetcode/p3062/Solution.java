package leetcode.p3062;

import common.ListNode;

public class Solution {

    public String gameResult(ListNode head) {
        int even = 0;
        int odd = 0;

        while (head != null) {
            ListNode next = head.next;
            if (head.val > next.val) {
                even++;
            } else if (head.val < next.val) {
                odd++;
            }
            head = next.next;
        }

        if (even > odd) {
            return "Even";
        } else if (even < odd) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}
