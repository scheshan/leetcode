package leetcode.p1725;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int res = 0;

        for (int[] pair : rectangles) {
            int n = Math.min(pair[0], pair[1]);
            if (n > max) {
                max = n;
                res = 1;
            } else if (n == max) {
                res++;
            }
        }
        return res;
    }
}
