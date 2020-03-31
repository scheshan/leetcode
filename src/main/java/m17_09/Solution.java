package m17_09;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/31
 */
public class Solution {

    public int getKthMagicNumber(int k) {
        int[] arr = new int[k + 1];
        arr[1] = 1;

        int p3 = 1;
        int p5 = 1;
        int p7 = 1;

        for (int i = 2; i <= k; i++) {
            int n3 = arr[p3] * 3;
            int n5 = arr[p5] * 5;
            int n7 = arr[p7] * 7;

            arr[i] = Math.min(n3, Math.min(n5, n7));

            if (n3 == arr[i]) {
                p3++;
            }
            if (n5 == arr[i]) {
                p5++;
            }
            if (n7 == arr[i]) {
                p7++;
            }
        }

        return arr[k];
    }
}
