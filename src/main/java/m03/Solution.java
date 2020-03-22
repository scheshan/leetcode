package m03;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        for (int n : nums) {
            n = Math.abs(n);

            if (nums[n] < 0) {
                return n;
            }
            if (n == 0) {
                if (nums[0] == nums.length) {
                    return 0;
                }
                nums[n] = nums.length;
            } else {
                nums[n] *= -1;
            }
        }

        return -1;
    }
}
