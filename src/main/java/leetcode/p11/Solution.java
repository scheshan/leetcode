package leetcode.p11;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;

        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
