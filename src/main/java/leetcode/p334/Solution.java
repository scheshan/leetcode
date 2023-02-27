package leetcode.p334;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > n2) {
                return true;
            }

            if (num < n1) {
                n1 = num;
            } else if (num < n2 && num > n1) {
                n2 = num;
            }
        }

        return false;
    }
}
