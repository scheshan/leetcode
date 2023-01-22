package leetcode.p347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.compute(num, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.getValue() - o2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.remove();
                    queue.add(entry);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove().getKey();
        }
        return res;
    }
}
