package l762;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/18
 */
public class Solution {

    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);
        primes.add(31);

        int[] count = new int[1000001];
        for (int i = 1; i < count.length; i++) {
            int pre = i >> 1;
            count[i] = count[pre] + (i & 1);
        }

        int res = 0;
        for (int i = L; i <= R; i++) {
            int c = count[i];
            if (primes.contains(c)) {
                res++;
            }
        }
        return res;
    }
}
