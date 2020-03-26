package l1266;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/26
 */
public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        int[] prev = null;
        for (int[] point : points) {
            if (prev != null) {
                int n = Math.max(Math.abs(point[0] - prev[0]), Math.abs(point[1] - prev[1]));
                res += n;
            }
            prev = point;
        }

        return res;
    }
}
