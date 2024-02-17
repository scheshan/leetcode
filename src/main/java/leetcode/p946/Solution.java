package leetcode.p946;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/18
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>(pushed.length);

        int l = 0, r = 0;
        while (r < pushed.length) {
            if (!deque.isEmpty() && deque.peekLast() == popped[r]) {
                deque.removeLast();
                r++;
            } else if (l < pushed.length) {
                deque.addLast(pushed[l++]);
            } else {
                return false;
            }
        }

        return r == popped.length;
    }
}
