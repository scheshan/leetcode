package leetcode.p2520;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int countDigits(int num) {
        int res = 0;

        int n = num;
        while (n != 0) {
            int a = n % 10;
            if (a != 0 && num % a == 0) {
                res++;
            }
            n /= 10;
        }

        return res;
    }
}
