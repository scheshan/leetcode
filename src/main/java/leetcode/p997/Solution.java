package leetcode.p997;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/6
 */
public class Solution {

    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for (int[] arr : trust) {
            in[arr[1]]++;
            out[arr[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
