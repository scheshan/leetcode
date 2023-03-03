package leetcode.p45;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/3
 */
public class Solution {

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int step = 0;
        int l = 0;
        int r = l + nums[0];

        while (r < nums.length - 1) {
            int max = l + nums[l];
            for (int i = l; i <= r; i++) {
                max = Math.max(max, i + nums[i]);
            }
            l = r + 1;
            r = max;
            step++;
        }
        return step + 1;
    }
}
