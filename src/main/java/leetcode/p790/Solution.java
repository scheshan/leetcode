package leetcode.p790;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int numTilings(int n) {
        int mod = 1000000007;
        int n0 = 0, n1 = 0, n2 = 0, n3 = 1;

        for (int i = 1; i <= n; i++) {
            int m0 = n3 % mod;
            int m1 = (n0 + n2) % mod;
            int m2 = (n0 + n1) % mod;
            int m3 = ((((n0 + n1) % mod + n2) % mod) + n3) % mod;

            n0 = m0;
            n1 = m1;
            n2 = m2;
            n3 = m3;
        }

        return n3;
    }
}
