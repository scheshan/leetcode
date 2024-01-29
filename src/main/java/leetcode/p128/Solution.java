package leetcode.p128;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int cnt = 0;
            while (set.contains(num)) {
                cnt++;
                num++;
            }
            res = Math.max(res, cnt);
        }

        return res;
    }
}
