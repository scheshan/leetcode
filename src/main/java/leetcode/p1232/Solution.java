package leetcode.p1232;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x1 = coordinates[i][0] - coordinates[i - 1][0];
            int y1 = coordinates[i][1] - coordinates[i - 1][1];

            if (x1 * y != x * y1) {
                return false;
            }
        }
        return true;
    }
}
