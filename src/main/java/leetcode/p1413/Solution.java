package leetcode.p1413;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }

        return -min + 1;
    }
}
