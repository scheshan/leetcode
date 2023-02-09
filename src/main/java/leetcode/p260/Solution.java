package leetcode.p260;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    public int[] singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }

        n = n - (n & (n - 1));
        int x = 0;
        int y = 0;

        for (int num : nums) {
            if ((num & n) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
