package offer.p03;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        int delta = 1000000;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                num += delta;
            }
            if (nums[num] < 0) {
                return num;
            }

            nums[num] -= delta;
        }

        return 0;
    }
}
