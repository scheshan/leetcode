package leetcode.p2357;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int minimumOperations(int[] nums) {
        boolean[] set = new boolean[101];
        int res = 0;
        for (int num : nums) {
            if (num > 0 && !set[num]) {
                set[num] = true;
                res++;
            }
        }
        return res;
    }
}
