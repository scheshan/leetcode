package leetcode.p1470;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/22
 */
public class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            res[ind++] = nums[i];
            res[ind++] = nums[i + n];
        }
        return res;
    }
}
