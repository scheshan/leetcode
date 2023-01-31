package leetcode.p1196;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/31
 */
public class Solution {

    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);

        int res = 0;
        int total = 0;
        for (int i = 0; i < weight.length; i++) {
            total += weight[i];
            if (total <= 5000) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
