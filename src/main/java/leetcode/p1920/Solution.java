package leetcode.p1920;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
