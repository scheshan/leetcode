package leetcode.p2154;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        int res = original;
        while (set.contains(res)) {
            res <<= 1;
        }
        return res;
    }
}
