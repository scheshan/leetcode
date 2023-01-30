package leetcode.p487;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int zero = 0;

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                zero++;
            }

            while (zero > 1) {
                if (nums[l++] == 0) {
                    zero--;
                }
            }
            if (r - l > res) {
                res = r - l;
            }
        }
        return res;
    }
}
