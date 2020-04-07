package l1128;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];

        for (int[] domino : dominoes) {
            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);

            map[min][max]++;
        }

        int res = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (map[i][j] > 1) {
                    res += map[i][j] * (map[i][j] - 1) / 2;
                }
            }
        }

        return res;
    }
}
