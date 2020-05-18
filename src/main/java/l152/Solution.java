package l152;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/18
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0) {
                max = Math.max(max * n, n);
                min = min * n;

                res = Math.max(res, max);
            } else if (n < 0) {
                int m = min * n;
                min = Math.min(max * n, n);
                max = m;

                res = Math.max(res, max);
            } else {
                res = Math.max(res, 0);

                max = 1;
                min = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().maxProduct(new int[]{-4, -3, -2});
        System.out.println(res);
    }
}
