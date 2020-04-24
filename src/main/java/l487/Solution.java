package l487;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int res = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros <= 1) {
                res = Math.max(res, right - left + 1);
            }
            right++;

            while (zeros > 1 && left < right) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
        System.out.println(res);
    }
}
