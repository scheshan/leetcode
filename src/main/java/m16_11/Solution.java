package m16_11;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/1
 */
public class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }

        int[] res = new int[k + 1];
        int base = shorter * k;

        for (int i = 0; i <= k; i++) {
            res[i] = base + i * (longer - shorter);
        }

        return res;
    }
}
