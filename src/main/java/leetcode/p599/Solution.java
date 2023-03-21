package leetcode.p599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/21
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (!map.containsKey(str)) {
                continue;
            }

            int sum = map.get(str) + i;
            if (sum < min) {
                res.clear();
                res.add(str);
                min = sum;
            } else if (sum == min) {
                res.add(str);
            }
        }

        String[] arr = new String[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
