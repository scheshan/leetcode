package leetcode.p2323;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/6
 */
public class Solution {

    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);

        int res = 0;
        for (int i = 0; i < jobs.length; i++) {
            int days = jobs[i] / workers[i];
            if (jobs[i] % workers[i] != 0) {
                days++;
            }
            res = Math.max(res, days);
        }
        return res;
    }
}
