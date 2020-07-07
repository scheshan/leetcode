package l1503;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/7/7
 */
public class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(left[i], max);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < right.length; i++) {
            min = Math.min(right[i], min);
        }

        if (min != Integer.MAX_VALUE) {
            min = n - min;
        } else {
            min = -1;
        }

        return Math.max(max, min);
    }
}
