package l747;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int mi = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                mi = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }

        return max1 >= max2 * 2 ? mi : -1;
    }
}
