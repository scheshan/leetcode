package leetcode.p762;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/21
 */
public class Solution {

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (match(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean match(int num) {
        int cnt = Integer.bitCount(num);

        return isPrime(cnt);
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
