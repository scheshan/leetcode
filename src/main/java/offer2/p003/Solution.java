package offer2.p003;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int pre = i >> 1;
            res[i] = res[pre] + (i & 1);
        }
        return res;
    }
}
