package l946;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();

        int l = 0;
        int r = 0;

        while (l < pushed.length && r < popped.length) {
            if (!deque.isEmpty() && deque.peekLast() == popped[r]) {
                deque.removeLast();
                r++;
            } else {
                deque.addLast(pushed[l++]);
            }
        }

        while (r < popped.length) {
            if (deque.isEmpty() || deque.peekLast() != popped[r]) {
                return false;
            }
            deque.removeLast();
            r++;
        }

        return l == pushed.length;
    }

    public static void main(String[] args) {
        new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
