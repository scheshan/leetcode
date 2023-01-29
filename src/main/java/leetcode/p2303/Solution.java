package leetcode.p2303;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/29
 */
public class Solution {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0;

        int ind = 0;
        int pre = 0;
        while (income > 0) {
            int n = Math.min(income, brackets[ind][0] - pre);
            res += n * brackets[ind][1] * 1.0 / 100;
            income -= n;
            pre = brackets[ind][0];
            ind++;
        }
        return res;
    }
}
