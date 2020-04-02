package l659;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int size = 1;

            if (map.containsKey(num - 1)) {
                PriorityQueue<Integer> queue = map.get(num - 1);
                size = queue.remove();
                size++;

                if (queue.isEmpty()) {
                    map.remove(num - 1);
                }
            }

            PriorityQueue<Integer> queue;
            if (map.containsKey(num)) {
                queue = map.get(num);
            } else {
                queue = new PriorityQueue<>();
                map.put(num, queue);
            }
            queue.add(size);
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
