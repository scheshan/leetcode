package l739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    private class Tuple {
        int index;

        int value;

        public Tuple(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Deque<Tuple> deque = new LinkedList<>();

        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!deque.isEmpty() && T[i] > deque.peekLast().value) {
                Tuple t = deque.removeLast();
                res[t.index] = i - t.index;
            }

            deque.addLast(new Tuple(i, T[i]));
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
