package offer2.p058;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/13
 */
public class MyCalendar {

    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (map.containsKey(start)) {
            return false;
        }

        Map.Entry<Integer, Integer> e1 = map.lowerEntry(start);
        if (e1 != null && e1.getValue() > start) {
            return false;
        }

        Map.Entry<Integer, Integer> e2 = map.higherEntry(start);
        if (e2 != null && e2.getKey() < end) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}
