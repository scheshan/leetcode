package leetcode.p1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int delta = target - num;

            if (map.containsKey(delta)) {
                return new int[]{map.get(delta), i};
            }
            map.put(num, i);
        }

        return null;
    }
}
