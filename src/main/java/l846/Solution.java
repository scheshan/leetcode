package l846;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/19
 */
public class Solution {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.compute(num, (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();
            reduce(map, first);

            for (int i = 1; i < W; i++) {
                first++;
                if (!reduce(map, first)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean reduce(Map<Integer, Integer> map, int key) {
        if (!map.containsKey(key)) {
            return false;
        }

        int c = map.get(key);
        c--;
        if (c == 0) {
            map.remove(key);
        } else {
            map.put(key, c);
        }
        return true;
    }
}
