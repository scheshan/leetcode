package l42;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/4
 */
public class Solution {

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
        }

        int res = 0;
        int rightMax = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            res += Math.max(0, Math.min(leftMax[i], rightMax) - height[i]);
            rightMax = Math.max(rightMax, height[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
