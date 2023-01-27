package leetcode.p1518;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/27
 */
public class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        while (numBottles > 0) {
            if (numBottles >= numExchange) {
                int n = numBottles / numExchange;
                res += n * numExchange;
                numBottles -= n * numExchange;
                numBottles += n;
            } else {
                res += numBottles;
                numBottles = 0;
            }
        }
        return res;
    }
}
