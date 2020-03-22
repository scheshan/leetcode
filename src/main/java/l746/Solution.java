package l746;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        if (cost.length == 1) {
            return cost[0];
        }

        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
