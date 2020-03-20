package l11;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/20
 */
public class Solution {

    public int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int l = height[left];
            int r = height[right];

            result = Math.max(Math.min(l, r) * (right - left), result);

            if (l > r) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().maxArea(new int[]{1, 2, 4, 3});
    }
}
