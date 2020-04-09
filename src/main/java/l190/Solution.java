package l190;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/9
 */
public class Solution {

    public int reverseBits(int n) {
        int res = 0;

        int i = 31;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res | (1 << i);
            }

            i--;
            n >>>= 1;
        }

        return res;
    }
}
