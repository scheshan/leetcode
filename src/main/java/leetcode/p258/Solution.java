package leetcode.p258;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }

        return addDigits(res);
    }
}
