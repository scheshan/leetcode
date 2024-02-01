package leetcode.p560;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);

        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;

            if (pre.containsKey(sum - k)) {
                res += pre.get(sum - k);
            }

            pre.put(sum, pre.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
