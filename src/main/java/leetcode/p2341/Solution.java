package leetcode.p2341;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/21
 */
public class Solution {

    public int[] numberOfPairs(int[] nums) {
        boolean[] arr = new boolean[101];
        int res = 0;

        for (int num : nums) {
            if (arr[num]) {
                res++;
                arr[num] = false;
            } else {
                arr[num] = true;
            }
        }

        return new int[]{res, nums.length - (res << 1)};
    }
}
