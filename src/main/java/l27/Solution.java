package l27;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int low = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                if (fast != low) {
                    nums[low] = nums[fast];
                }
                low++;
                fast++;
            } else {
                fast++;
            }
        }

        return low;
    }
}
