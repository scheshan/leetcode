package leetcode.p817;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/19
 */
public class Solution {

    public int numComponents(ListNode head, int[] nums) {
        int res = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int cur = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (cur == 0) {
                    res++;
                }
                cur++;
            } else {
                cur = 0;
            }
            head = head.next;
        }

        return res;
    }
}
