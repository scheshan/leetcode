package l560;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int pre = 0;
        for (int num : nums) {
            int n = pre + num;
            pre = n;

            res += map.getOrDefault(n - k, 0);
            map.compute(n, (x, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return res;
    }
}
