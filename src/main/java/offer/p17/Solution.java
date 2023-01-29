package offer.p17;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/30
 */
public class Solution {

    public int[] printNumbers(int n) {
        int total = 10;
        for (int i = 1; i < n; i++) {
            total *= 10;
        }

        int[] res = new int[total - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
