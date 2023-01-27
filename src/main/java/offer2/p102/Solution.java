package offer2.p102;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> state = null;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> s2 = new HashMap<>();
            if (i == 0) {
                if (nums[i] == 0) {
                    s2.put(0, 2);
                } else {
                    s2.put(nums[i], 1);
                    s2.put(-nums[i], 1);
                }
            } else {
                for (Map.Entry<Integer, Integer> entry : state.entrySet()) {
                    s2.compute(entry.getKey() + nums[i], (k, v) -> {
                        if (v == null) {
                            return entry.getValue();
                        }
                        return v + entry.getValue();
                    });
                    s2.compute(entry.getKey() - nums[i], (k, v) -> {
                        if (v == null) {
                            return entry.getValue();
                        }
                        return v + entry.getValue();
                    });
                }
            }
            state = s2;
        }

        return state.getOrDefault(target, 0);
    }
}
