package leetcode.p75;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public void sortColors(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;
        for (int num : nums) {
            if (num == 0) {
                n0++;
            } else if (num == 1) {
                n1++;
            } else {
                n2++;
            }
        }

        int ind = 0;
        for (int i = 0; i < n0; i++) {
            nums[ind++] = 0;
        }
        for (int i = 0; i < n1; i++) {
            nums[ind++] = 1;
        }
        for (int i = 0; i < n2; i++) {
            nums[ind++] = 2;
        }
    }
}
