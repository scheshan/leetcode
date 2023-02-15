package leetcode.p1437;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/15
 */
public class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre >= 0 && i - pre - 1 < k) {
                    return false;
                }
                pre = i;
            }
        }
        return true;
    }
}
