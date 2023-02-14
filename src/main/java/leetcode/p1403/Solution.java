package leetcode.p1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int cur = 0;
        int ind = nums.length - 1;
        while (ind > 0) {
            cur += nums[ind];
            if (cur > sum - cur) {
                break;
            }
            ind--;
        }

        List<Integer> res = new ArrayList<>(nums.length - ind + 1);
        for (int i = nums.length - 1; i >= ind; i--) {
            res.add(nums[i]);
        }
        return res;
    }
}
