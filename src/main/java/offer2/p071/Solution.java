package offer2.p071;

import java.util.Random;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    private int[] w;

    private int max;

    private Random rnd;

    public Solution(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.w = w;
        max = w[w.length - 1];
        rnd = new Random();
    }

    public int pickIndex() {
        int num = rnd.nextInt(max);

        int l = 0;
        int r = w.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (num >= w[mid]) {
                l = mid + 1;
            } else {
                if (mid == 0 || num >= w[mid - 1]) {
                    return mid;
                }
                r = mid;
            }
        }
        return 0;
    }
}
