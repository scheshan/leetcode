package leetcode.p2562;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public long findTheArrayConcVal(int[] nums) {
        long res = 0;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                res += nums[l];
            } else {
                int x = nums[l];
                int y = nums[r];
                while (y > 0) {
                    x *= 10;
                    y /= 10;
                }
                res += x + nums[r];
            }
            l++;
            r--;
        }
        return res;
    }
}
