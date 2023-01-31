package interview.p05_06;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int convertInteger(int A, int B) {
        int res = 0;

        while (A != 0 || B != 0) {
            if ((A & 1) != (B & 1)) {
                res++;
            }
            A >>>= 1;
            B >>>= 1;
        }
        return res;
    }
}
