package leetcode.p1716;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int res = (1 + 7) * 7 / 2 * weeks;
        if (weeks > 1) {
            res += 7 * weeks * (weeks - 1) / 2;
        }
        if (days > 0) {
            res += (1 + weeks + 1 + weeks + days - 1) * days / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().totalMoney(21);
    }
}
