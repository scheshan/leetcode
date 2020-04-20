package m17_21;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/20
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
}
