package leetcode.p1085;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int res = 0;
        while (min > 0) {
            res += min % 10;
            min /= 10;
        }
        return 1 - (res & 1);
    }
}
