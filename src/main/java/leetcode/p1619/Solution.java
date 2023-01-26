package leetcode.p1619;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int l = arr.length / 20;
        int r = arr.length - arr.length / 20;

        double sum = 0;
        for (int i = l; i < r; i++) {
            sum += arr[i];
        }
        return sum / (r - l);
    }
}
