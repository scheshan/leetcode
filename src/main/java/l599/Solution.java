package l599;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> list = new LinkedList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < min) {
                    min = sum;
                    list.clear();
                    list.add(list2[i]);
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }

        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) {
            res[i++] = str;
        }

        return res;
    }
}
