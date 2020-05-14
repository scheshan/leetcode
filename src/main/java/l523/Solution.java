package l523;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/14
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int sum = 0;
        prefix.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (prefix.containsKey(sum)) {
                if (i - prefix.get(sum) > 1) {
                    return true;
                }
            } else {
                prefix.put(sum, i);
            }
        }

        return false;
    }
}
