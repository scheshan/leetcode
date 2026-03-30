package leetcode.p234;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if ((int) list.get(l++) != (int) list.get(r--)) {
                return false;
            }
        }

        return true;
    }
}
