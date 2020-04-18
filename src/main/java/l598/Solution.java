package l598;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;

        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }

        return (minX - 0) * (minY - 0);
    }
}
