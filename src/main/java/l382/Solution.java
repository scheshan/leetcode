package l382;

import shared.ListNode;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/6
 */
class Solution {

    private ListNode head;

    private Random rnd;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
        rnd = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int res = head.val;

        ListNode cur = head.next;
        int i = 0;
        while (cur != null) {
            if (random(i + 1) == i) {
                res = cur.val;
            }
            cur = cur.next;
            i++;
        }

        return res;
    }

    private int random(int n) {
        return rnd.nextInt(n);
    }
}
