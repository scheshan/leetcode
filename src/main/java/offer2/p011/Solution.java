package offer2.p011;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == 1 ? 1 : -1;
            if (cnt == 0) {
                res = Math.max(res, i + 1);
            }

            if (map.containsKey(cnt)) {
                res = Math.max(res, i - map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        }
        return res;
    }
}
