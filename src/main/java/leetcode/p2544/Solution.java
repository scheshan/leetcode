package leetcode.p2544;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int alternateDigitSum(int n) {
        int res = 0;
        int count = 0;
        int multiple = 1;
        while (n > 0) {
            res += (multiple * n % 10);
            n /= 10;
            multiple = -multiple;
            count++;
        }

        if ((count & 1) == 0) {
            res = -res;
        }
        return res;
    }
}
