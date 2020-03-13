package l169;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/13
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
}
