package leetcode.p334;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {
        Integer n1 = null, n2 = null;

        for (int num : nums) {
            if (n1 == null || num < n1) {
                n1 = num;
            } else if (num > n1 && (n2 == null || num < n2)) {
                n2 = num;
            } else if (n2 != null && num > n2) {
                return true;
            }
        }

        return false;
    }
}
