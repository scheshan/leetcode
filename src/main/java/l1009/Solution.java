package l1009;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/26
 */
public class Solution {

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }

        int res = 0;
        int left = 0;
        while (N != 0) {
            res |= 1 - (N & 1) << left;

            left++;
            N >>= 1;
        }
        return res;
    }
}
