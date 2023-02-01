package leetcode.p170;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 *
 * @author heshan
 * @date 2023/2/1
 */
public class TwoSum {

    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int delta = value - entry.getKey();
            if (delta == entry.getKey() && entry.getValue() > 1) {
                return true;
            }
            if (delta != entry.getKey() && map.containsKey(delta)) {
                return true;
            }
        }
        return false;
    }
}
