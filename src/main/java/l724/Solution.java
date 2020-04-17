package l724;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/17
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur * 2 + nums[i] == total) {
                return i;
            }
            cur += nums[i];
        }

        return -1;
    }
}
