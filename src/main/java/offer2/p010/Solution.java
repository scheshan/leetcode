package offer2.p010;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur == k) {
                res++;
            }
            if (map.containsKey(cur - k)) {
                res += map.get(cur - k);
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}
