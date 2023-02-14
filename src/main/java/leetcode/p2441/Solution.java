package leetcode.p2441;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;

        for (int num : nums) {
            if (set.contains(-num)) {
                res = Math.max(res, Math.abs(num));
            }
            set.add(num);
        }
        return res;
    }
}
