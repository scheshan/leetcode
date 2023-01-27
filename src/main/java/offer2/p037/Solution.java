package offer2.p037;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : asteroids) {
            if (num > 0) {
                deque.addLast(num);
            } else {
                while (!deque.isEmpty() && deque.peekLast() <= -num) {
                    if (deque.removeLast() == -num) {
                        num = 0;
                    }
                }
                if (num != 0 && deque.isEmpty()) {
                    list.add(num);
                }
            }
        }
        list.addAll(deque);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
