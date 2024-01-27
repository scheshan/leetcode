package leetcode.p274;

import java.util.Arrays;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/27
 */
public class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int res = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int cnt = citations.length - i;
            if(citations[i] >= cnt) {
                res = cnt;
            }
        }

        return res;
    }
}
