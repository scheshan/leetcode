package l997;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/22
 */
public class Solution {

    public int findJudge(int N, int[][] trust) {
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];

        for (int[] edge : trust) {
            in[edge[1]]++;
            out[edge[0]]++;
        }

        for (int i = 1; i < in.length; i++) {
            if (in[i] == N - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
