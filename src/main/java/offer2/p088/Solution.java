package offer2.p088;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n1 = cost[0];
        int n2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int n3 = Math.min(n1, n2) + cost[i];
            n1 = n2;
            n2 = n3;
        }

        return Math.min(n1, n2);
    }
}
