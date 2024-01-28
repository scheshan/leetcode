package leetcode.p746;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/28
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n1 = 0, n2 = 0;

        for (int i = 0; i < cost.length; i++) {
            int num = Math.min(n1, n2) + cost[i];
            n1 = n2;
            n2 = num;
        }

        return Math.min(n1, n2);
    }
}
