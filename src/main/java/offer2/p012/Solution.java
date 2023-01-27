package offer2.p012;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre == total - pre - nums[i]) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }
}
