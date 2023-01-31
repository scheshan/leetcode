package leetcode.p1046;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o2, o1);
        });

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int n1 = queue.remove();
            int n2 = queue.remove();
            int n = n1 - n2;
            if (n > 0) {
                queue.add(n);
            }
        }
        return queue.size() > 0 ? queue.remove() : 0;
    }
}
