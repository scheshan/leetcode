package leetcode.p1779;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/2
 */
public class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int res = -1;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] != x && point[1] != y) {
                continue;
            }

            int d = Math.abs(point[0] - x) + Math.abs(point[1] - y);
            if (d < min) {
                res = i;
                min = d;
            }
        }
        return res;
    }
}
