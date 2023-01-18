package leetcode.p2465;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();

        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            set.add((nums[l++] + nums[r--]) / 2.0);
        }

        return set.size();
    }
}
