package lcp.p55;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/18
 */
public class Solution {

    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int res = 0;
        for (int[] fruit : fruits) {
            int n = fruit[1] / limit;
            if (fruit[1] % limit > 0) {
                n++;
            }
            res += time[fruit[0]] * n;
        }

        return res;
    }
}
