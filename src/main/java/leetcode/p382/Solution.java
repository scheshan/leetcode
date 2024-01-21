package leetcode.p382;

import common.ListNode;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/21
 */
public class Solution {

    private ListNode head;

    private Random rnd;

    public Solution(ListNode head) {
        this.head = head;
        this.rnd = new Random();
    }

    public int getRandom() {
        ListNode selected = null;
        int total = 0;

        ListNode head = this.head;
        while (head != null) {
            total++;
            if (rnd.nextInt(total) == 0) {
                selected = head;
            }
            head = head.next;
        }

        return selected.val;
    }
}
