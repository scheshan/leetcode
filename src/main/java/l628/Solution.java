package l628;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n1 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int n2 = nums[nums.length - 1] * nums[0] * nums[1];
        return Math.max(n1, n2);
    }
}
