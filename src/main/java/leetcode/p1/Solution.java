package leetcode.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/11/5
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int d = target - n;

            if (map.containsKey(d)) {
                return new int[]{i, map.get(d)};
            }

            map.put(n, i);
        }

        return null;
    }
}
