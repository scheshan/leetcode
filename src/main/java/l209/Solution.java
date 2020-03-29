package l209;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;

        int res = Integer.MAX_VALUE;
        int cur = 0;

        while (right < nums.length) {
            cur += nums[right++];

            while (cur >= s) {
                res = Math.min(right - left, res);

                cur -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        new Solution().minSubArrayLen(3, new int[]{1, 1});
    }
}
