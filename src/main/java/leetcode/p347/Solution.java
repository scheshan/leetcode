package leetcode.p347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/5
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(k + 1, (o1, o2) -> {
            return Integer.compare(cnt.get(o1), cnt.get(o2));
        });

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() > k) {
                queue.remove();
            }
        }

        int[] res = new int[queue.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.remove();
        }

        return res;
    }
}
