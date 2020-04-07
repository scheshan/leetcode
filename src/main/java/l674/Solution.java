package l674;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = 1;
        int cur = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cur = 1;
            } else {
                if (nums[i] > nums[i - 1]) {
                    cur++;
                    res = Math.max(res, cur);
                } else {
                    cur = 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5});
    }
}
