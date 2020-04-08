package l1403;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/8
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        List<Integer> res = new LinkedList<>();
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur += nums[i];

            if (cur > total - cur) {
                for (int j = nums.length - 1; j >= i; j--) {
                    res.add(nums[j]);
                }
                return res;
            }
        }

        return null;
    }
}
