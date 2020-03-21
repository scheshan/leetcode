package l1046;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int n : stones) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.remove();
            }

            int x = queue.remove();
            int y = queue.remove();

            int z = x - y;
            if (z > 0) {
                queue.add(z);
            }
        }

        return 0;
    }
}
