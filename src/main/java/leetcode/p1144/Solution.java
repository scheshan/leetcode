package leetcode.p1144;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int movesToMakeZigzag(int[] nums) {
        int r1 = 0;
        int r2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i] + 1;
            if (i > 0) {
                left = nums[i - 1];
            }
            int right = nums[i] + 1;
            if (i < nums.length - 1) {
                right = nums[i + 1];
            }

            int min = Math.min(left, right);
            if (nums[i] >= min) {
                if ((i & 1) == 0) {
                    r1 += nums[i] - min + 1;
                } else {
                    r2 += nums[i] - min + 1;
                }
            }
        }
        return Math.min(r1, r2);
    }

    public static void main(String[] args) {
        new Solution().movesToMakeZigzag(new int[]{9, 6, 1, 6, 2});
    }
}
