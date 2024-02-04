package leetcode.p42;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/5
 */
public class Solution {

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            if (i > 0) {
                left = Math.max(left, leftMax[i - 1]);
            }
            leftMax[i] = left;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            int right = height[i];
            if (i < height.length - 1) {
                right = Math.max(right, rightMax[i + 1]);
            }
            rightMax[i] = right;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }
}
