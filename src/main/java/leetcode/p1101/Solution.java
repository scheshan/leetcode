package leetcode.p1101;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/1
 */
public class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));

        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        int cnt = n;

        for (int[] log : logs) {
            if (connect(uf, log[1], log[2])) {
                cnt--;
            }
            if (cnt == 1) {
                return log[0];
            }
        }
        return -1;
    }

    private int getParent(int[] uf, int i) {
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }

    private boolean connect(int[] uf, int i, int j) {
        int p1 = getParent(uf, i);
        int p2 = getParent(uf, j);
        if (p1 != p2) {
            uf[p1] = p2;
            return true;
        }
        return false;
    }
}
