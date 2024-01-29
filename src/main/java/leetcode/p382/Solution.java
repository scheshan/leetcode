package leetcode.p382;

import common.ListNode;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    private ListNode head;

    private Random rnd;

    public Solution(ListNode head) {
        this.head = head;
        rnd = new Random();
    }

    public int getRandom() {
        ListNode cur = head;
        int total = 0;
        int res = head.val;

        while (cur != null) {
            total++;
            if (rnd.nextInt(total) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }

        return res;
    }
}
