package offer.p31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();

        int l = 0;
        int r = 0;
        while (l < pushed.length && r < popped.length) {
            if (deque.isEmpty() || deque.peekLast() != popped[r]) {
                deque.addLast(pushed[l++]);
            }

            while (r < popped.length && !deque.isEmpty() && deque.peekLast() == popped[r]) {
                deque.removeLast();
                r++;
            }
        }
        return l == pushed.length && deque.isEmpty();
    }
}
