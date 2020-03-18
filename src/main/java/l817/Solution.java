package l817;

import shared.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int n : G) {
            set.add(n);
        }

        int result = 0;
        int cur = 0;

        while (head != null) {
            if (set.contains(head.val)) {
                cur++;
            } else {
                if (cur > 0) {
                    result++;
                }

                cur = 0;
            }

            head = head.next;
        }

        if (cur > 0) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        new Solution().numComponents(head, new int[]{0, 2});
    }
}
