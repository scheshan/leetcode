package leetcode.p1464;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int m1 = 0;
        int m2 = 0;

        for (int num : nums) {
            if (num > m2) {
                m2 = num;
            }
            if (m2 > m1) {
                int tmp = m1;
                m1 = m2;
                m2 = tmp;
            }
        }
        return (m1 - 1) * (m2 - 1);
    }
}
