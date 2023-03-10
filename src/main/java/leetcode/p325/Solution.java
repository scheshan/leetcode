package leetcode.p325;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/10
 */
public class Solution {

    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res = Math.max(res, i - map.get(pre - k));
            }
            if (!map.containsKey(pre)) {
                map.put(pre, i);
            }
        }

        return res;
    }
}
