package l287;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n] < 0) {
                return n;
            }
            nums[n] = -1 * nums[n];
        }

        return -1;
    }
}
