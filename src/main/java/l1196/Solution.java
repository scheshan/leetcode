package l1196;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/24
 */
public class Solution {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);

        int res = 0;
        int cur = 0;
        for (int n : arr) {
            cur += n;
            if (cur <= 5000) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
