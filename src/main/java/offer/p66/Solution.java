package offer.p66;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/1
 */
public class Solution {

    public int[] constructArr(int[] a) {
        int[] suf = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) {
                suf[i] = a[i];
            } else {
                suf[i] = a[i] * suf[i + 1];
            }
        }

        int pre = 1;

        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            if (i < res.length - 1) {
                res[i] = pre * suf[i + 1];
            } else {
                res[i] = pre;
            }
            pre *= a[i];
        }
        return res;
    }
}
