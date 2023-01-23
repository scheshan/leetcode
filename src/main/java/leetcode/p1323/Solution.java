package leetcode.p1323;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int maximum69Number(int num) {
        int tmp = 0;
        while (num > 0) {
            tmp = tmp * 10 + num % 10;
            num /= 10;
        }

        int res = 0;
        boolean change = false;
        while (tmp > 0) {
            int n = tmp % 10;
            if (n == 6 && !change) {
                change = true;
                n = 9;
            }
            res = res * 10 + n;
            tmp /= 10;
        }
        return res;
    }
}
