package l313;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        int[] pointers = new int[primes.length];
        long[] tmp = new long[primes.length];

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                tmp[j] = res[pointers[j]] * primes[j];
                min = Math.min(min, tmp[j]);
            }

            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == min) {
                    pointers[j]++;
                }
            }

            res[i] = (int) min;
        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        new Solution().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }
}
