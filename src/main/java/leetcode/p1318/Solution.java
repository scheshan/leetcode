package leetcode.p1318;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/29
 */
public class Solution {

    public int minFlips(int a, int b, int c) {
        int res = 0, mask = 0;

        for (int i = 0; i < 32; i++) {
            mask = 1 << i;

            int n1 = a & mask;
            int n2 = b & mask;
            int n3 = c & mask;

            if (n3 != 0) {
                if (n1 == 0 && n2 == 0) {
                    res++;
                }
            } else {
                if (n1 != 0) {
                    res++;
                }
                if (n2 != 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
