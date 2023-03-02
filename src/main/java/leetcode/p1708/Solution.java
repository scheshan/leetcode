package leetcode.p1708;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/2
 */
public class Solution {

    public int[] largestSubarray(int[] nums, int k) {
        int ind = 0;
        for (int i = 1; i + k <= nums.length; i++) {
            if (nums[i] > nums[ind]) {
                ind = i;
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[ind + i];
        }
        return res;
    }
}
