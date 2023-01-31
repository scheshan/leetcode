package leetcode.p692;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            int n = Integer.compare(o1.getValue(), o2.getValue());
            if (n != 0) {
                return n;
            }
            return o2.getKey().compareTo(o1.getKey());
        });

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        List<String> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(queue.remove().getKey());
        }
        int l = 0;
        int r = res.size() - 1;
        while (l < r) {
            String tmp = res.get(l);
            res.set(l, res.get(r));
            res.set(r, tmp);
            l++;
            r--;
        }
        return res;
    }
}
