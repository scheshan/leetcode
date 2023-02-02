package leetcode.p1979;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        return get(max, min);
    }

    private int get(int x, int y) {
        int res = y;
        while (x % y != 0) {
            res = x % y;
            x = y;
            y = res;
        }
        return res;
    }
}
