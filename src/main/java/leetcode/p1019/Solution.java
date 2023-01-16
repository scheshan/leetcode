package leetcode.p1019;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        int total = 0;
        ListNode node = head;
        while (node != null) {
            total++;
            node = node.next;
        }

        int[] res = new int[total];
        Deque<int[]> deque = new LinkedList<>();
        int ind = 0;
        while (head != null) {
            while (!deque.isEmpty() && deque.peekLast()[1] < head.val) {
                res[deque.removeLast()[0]] = head.val;
            }
            deque.addLast(new int[]{ind, head.val});
            head = head.next;
            ind++;
        }

        while (!deque.isEmpty()) {
            res[deque.removeLast()[0]] = 0;
        }

        return res;
    }
}
