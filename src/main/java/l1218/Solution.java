package l1218;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/10
 */
public class Solution {

    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;

        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int d = arr[i] - difference;
            int c = dp.getOrDefault(d, 0) + 1;
            res = Math.max(res, c);

            dp.compute(arr[i], (k, v) -> {
                if (v == null) {
                    return c;
                }
                return Math.max(c, v);
            });
        }

        return res;
    }
}
