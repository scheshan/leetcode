package leetcode.p922;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;

        while (even < nums.length && odd < nums.length) {
            if ((nums[even] & 1) == 1) {
                int tmp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = tmp;

                odd += 2;
            } else {
                even += 2;
            }
        }

        return nums;
    }
}
