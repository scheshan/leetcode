package l283;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/18
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int low = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                if (low != fast) {
                    nums[low] = nums[fast];
                }
                low++;
                fast++;
            } else {
                fast++;
            }
        }

        while (low < nums.length) {
            nums[low] = 0;
            low++;
        }
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{1});
    }
}
