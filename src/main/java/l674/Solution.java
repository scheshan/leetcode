package l674;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        int res = 0;

        int slow = 0;
        while (slow < nums.length) {
            int fast = slow + 1;
            while (fast < nums.length && nums[fast] > nums[fast - 1]) {
                fast++;
            }

            res = Math.max(res, fast - slow);
            slow = fast;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5});
    }
}
