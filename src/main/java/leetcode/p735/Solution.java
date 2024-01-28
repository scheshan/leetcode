package leetcode.p735;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>(asteroids.length);

        Deque<Integer> deque = new ArrayDeque<>(asteroids.length);
        for (int num : asteroids) {
            if (num > 0) {
                deque.addLast(num);
            } else {
                boolean exist = true;
                while (!deque.isEmpty() && exist) {
                    if (deque.peekLast() < -num) {
                        deque.removeLast();
                    } else {
                        if (deque.peekLast() == -num) {
                            deque.removeLast();
                        }
                        exist = false;
                    }
                }
                if (exist) {
                    list.add(num);
                }
            }
        }

        while (!deque.isEmpty()) {
            list.add(deque.removeFirst());
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
