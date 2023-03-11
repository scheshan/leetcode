package interview.p17_05;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/11
 */
public class Solution {

    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int cnt = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                cnt++;
            } else {
                cnt--;
            }

            if (map.containsKey(cnt)) {
                if (i - map.get(cnt) > max) {
                    max = i - map.get(cnt);
                    start = map.get(cnt) + 1;
                }
            } else {
                map.put(cnt, i);
            }
        }

        String[] res = new String[max];
        if (max > 0) {
            System.arraycopy(array, start, res, 0, res.length);
        }
        return res;
    }
}
