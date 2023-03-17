package leetcode.p2488;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/16
 */
public class Solution {

    public int countSubarrays(int[] nums, int k) {
        int ind = -1;
        int cnt = 0;
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                ind = i;
            } else {
                cnt += nums[i] > k ? 1 : -1;
            }

            if (ind >= 0) {
                res += map.getOrDefault(cnt, 0);
                res += map.getOrDefault(cnt - 1, 0);
            } else {
                map.put(cnt, map.getOrDefault(cnt, 0) + 1);
            }
        }

        return res;
    }
}
