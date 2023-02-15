package leetcode.p1250;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public boolean isGoodArray(int[] nums) {
        int n = nums[0];
        for (int num : nums) {
            n = gcd(n, num);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
