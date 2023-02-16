package leetcode.p2558;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/17
 */
public class Solution {

    public long pickGifts(int[] gifts, int k) {
        long res = 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int num : gifts) {
            queue.add(num);
            res += num;
        }

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int num = queue.remove();
            if (num == 1) {
                break;
            }

            int n = (int) Math.sqrt(num);
            res -= num - n;
            queue.add(n);
        }
        return res;
    }
}
