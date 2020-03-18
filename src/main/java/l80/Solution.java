package l80;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums != null ? nums.length : 0;
        }

        int low = 1;
        int fast = 1;

        int prev = nums[0];
        int count = 1;
        while (fast < nums.length) {
            int num = nums[fast];
            if (prev == num) {
                count++;
            } else {
                prev = num;
                count = 1;
            }

            if (count > 2) {
                fast++;
            } else {
                if (low != fast) {
                    nums[low] = nums[fast];
                }
                low++;
                fast++;
            }
        }
        return low;
    }
}
