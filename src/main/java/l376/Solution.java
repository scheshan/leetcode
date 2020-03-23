package l376;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/23
 */
public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = 1;

        Boolean up = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (up == null) {
                up = nums[i] > nums[i - 1];
                res++;
            } else {
                if (up != nums[i] > nums[i - 1]) {
                    up = !up;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
    }
}
