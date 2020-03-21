package l692;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.compute(word, (w, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int r = o1.getValue().compareTo(o2.getValue());
                if (r != 0) {
                    return r;
                }
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.remove();
                    queue.add(entry);
                } else if (entry.getValue().equals(queue.peek().getValue()) && entry.getKey().compareTo(queue.peek().getKey()) < 0) {
                    queue.remove();
                    queue.add(entry);
                }
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.addFirst(queue.remove().getKey());
        }

        return result;
    }
}
