package m31;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();

        int i = 0, j = 0;
        while (true) {
            if (i >= pushed.length) {
                break;
            }

            if (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.removeLast();
                j++;
                continue;
            }

            deque.addLast(pushed[i++]);
        }
        while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
            deque.removeLast();
            j++;
            continue;
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {
        new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
