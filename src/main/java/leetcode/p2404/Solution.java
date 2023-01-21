package leetcode.p2404;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = -1;
        int max = 0;

        for (int num : nums) {
            if ((num & 1) == 0) {
                int cnt = count.compute(num, (k, v) -> {
                    if (v == null) {
                        v = 0;
                    }
                    return ++v;
                });
                if (cnt > max) {
                    res = num;
                    max = cnt;
                } else if (cnt == max) {
                    res = Math.min(res, num);
                }
            }
        }
        return res;
    }
}
