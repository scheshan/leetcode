package lcr.p091;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int minCost(int[][] costs) {
        int n0 = 0, n1 = 0, n2 = 0;

        for (int i = 0; i < costs.length; i++) {
            int m0 = Math.min(n1, n2) + costs[i][0];
            int m1 = Math.min(n0, n2) + costs[i][1];
            int m2 = Math.min(n0, n1) + costs[i][2];

            n0 = m0;
            n1 = m1;
            n2 = m2;
        }

        return Math.min(Math.min(n0, n1), n2);
    }
}
