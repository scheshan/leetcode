package leetcode.p1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = target - nums[i];
            if (map.containsKey(d)) {
                return new int[]{map.get(d), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
