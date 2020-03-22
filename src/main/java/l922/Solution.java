package l922;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int l = 0;
        int r = 1;

        for (int n : A) {
            if ((n & 1) == 1) {
                res[r] = n;
                r += 2;
            } else {
                res[l] = n;
                l += 2;
            }
        }

        return res;
    }
}
