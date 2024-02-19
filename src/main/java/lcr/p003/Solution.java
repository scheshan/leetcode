package lcr.p003;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/19
 */
public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n == 0) {
            return res;
        }

        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
