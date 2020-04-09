package l735;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();

        for (int num : asteroids) {
            if (deque.isEmpty()) {
                deque.addLast(num);
            } else {
                while (!deque.isEmpty()) {
                    int pre = deque.peekLast();
                    if (pre > 0 && num < 0) {
                        if (pre + num == 0) {
                            deque.removeLast();
                            break;
                        } else if (pre + num > 0) {
                            break;
                        } else {
                            deque.removeLast();
                            if (deque.isEmpty()) {
                                deque.addLast(num);
                                break;
                            }
                        }
                    } else {
                        deque.addLast(num);
                        break;
                    }
                }
            }
        }

        int[] res = new int[deque.size()];
        int i = 0;
        for (int num : deque) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().asteroidCollision(new int[]{5, 10, -5});
    }
}
