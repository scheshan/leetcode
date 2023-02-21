package leetcode.p2340;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/21
 */
public class Solution {

    public int minimumSwaps(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int indMin = 0;
        int indMax = 0;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < min) {
                min = n;
                indMin = i;
            } else if (n >= max) {
                max = n;
                indMax = i;
            }
        }

        int res = indMin + (nums.length - indMax - 1);
        if(indMin > indMax) {
            res--;
        }
        return res;
    }
}
