package l26;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int low = 1;
        int fast = 1;

        int prev = nums[0];
        while (fast < nums.length) {
            if (nums[fast] != prev) {
                if (low != fast) {
                    nums[low] = nums[fast];
                }
                prev = nums[fast];
                low++;
                fast++;
            } else {
                fast++;
            }
        }

        return low;
    }
}
