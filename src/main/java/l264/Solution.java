package l264;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[i2] * 2;
            int n3 = res[i3] * 3;
            int n5 = res[i5] * 5;

            res[i] = Math.min(n2, Math.min(n3, n5));
            if (res[i] == n2) {
                i2++;
            }
            if (res[i] == n3) {
                i3++;
            }
            if (res[i] == n5) {
                i5++;
            }
        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        new Solution().nthUglyNumber(10);
    }
}
