package leetcode.p2149;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = 1;

        for (int num : nums) {
            if (num > 0) {
                res[l] = num;
                l += 2;
            } else {
                res[r] = num;
                r += 2;
            }
        }

        return res;
    }
}
