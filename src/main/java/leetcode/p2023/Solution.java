package leetcode.p2023;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            if (num.length() >= target.length()) {
                continue;
            }
            if (target.indexOf(num) == 0) {
                res += map.getOrDefault(target.substring(num.length()), 0);
            }
            if (target.lastIndexOf(num) == target.length() - num.length()) {
                res += map.getOrDefault(target.substring(0, target.length() - num.length()), 0);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
