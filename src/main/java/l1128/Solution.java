package l1128;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];

        int res = 0;

        for (int[] domino : dominoes) {
            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);

            int ind = min * 10 + max;

            res += map[ind];
            map[ind]++;
        }

        return res;
    }
}
