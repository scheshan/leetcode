package leetcode.p2078;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int maxDistance(int[] colors) {
        int res = 0;

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            if (color != colors[0]) {
                res = Math.max(res, i);
            }
            if (color != colors[colors.length - 1]) {
                res = Math.max(res, colors.length - 1 - i);
            }
        }
        return res;
    }
}
