package leetcode.p382;

import common.ListNode;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    private ListNode head;

    private Random rnd;

    public Solution(ListNode head) {
        this.head = head;
        this.rnd = new Random();
    }

    public int getRandom() {
        ListNode node = head;
        int res = node.val;
        int cnt = 0;
        while (node != null) {
            cnt++;
            if (rnd.nextInt(cnt) == 0) {
                res = node.val;
            }
            node = node.next;
        }

        return res;
    }
}
