package leetcode.p981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TimeMap
 *
 * @author heshan
 * @date 2023/2/22
 */
public class TimeMap {

    private class Item {

        private int timestamp;

        private String value;

        public Item(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Item>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Item> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
            map.put(key, list);
        }
        list.add(new Item(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Item> list = map.get(key);
        if (list == null) {
            return "";
        }

        int l = 0;
        int r = list.size();
        String res = "";
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            Item item = list.get(mid);
            if (item.timestamp == timestamp) {
                res = item.value;
                break;
            } else if (item.timestamp < timestamp) {
                res = item.value;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return res;
    }
}
