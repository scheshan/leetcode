package leetcode.p2535;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/17
 */
public class Solution {

    public int differenceOfSum(int[] nums) {
        int n1 = 0;
        int n2 = 0;

        for (int num : nums) {
            n1 += num;

            while (num > 0) {
                n2 += num % 10;
                num /= 10;
            }
        }

        return Math.abs(n1 - n2);
    }
}
