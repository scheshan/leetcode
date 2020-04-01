package l1248;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + (isOdd(nums[i]) ? 1 : 0);
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : prefix) {
            res += map.getOrDefault(p - k, 0);
            map.compute(p, (key, v) -> {
                if (v == null) {
                    v = 0;
                }
                return ++v;
            });
        }

        return res;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        new Solution().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);
    }
}
