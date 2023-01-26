package leetcode.p1854;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/26
 */
public class Solution {

    public int maximumPopulation(int[][] logs) {
        int[] birth = new int[101];
        int[] death = new int[101];

        for (int[] log : logs) {
            birth[log[0] - 1950]++;
            death[log[1] - 1950]++;
        }

        int max = 0;
        int ind = 0;
        int pre = 0;
        for (int i = 0; i < birth.length; i++) {
            pre = pre + birth[i] - death[i];
            if (pre > max) {
                max = pre;
                ind = i;
            }
        }

        return 1950 + ind;
    }
}
