package leetcode.p1822;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int arraySign(int[] nums) {
        boolean negative = false;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negative = !negative;
            }
        }
        return negative ? -1 : 1;
    }
}
