package leetcode.p305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] uf = new int[m * n];
        Arrays.fill(uf, -1);

        int[][] directions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int[] pos : positions) {
            int row = pos[0], col = pos[1];
            int ind = getInd(row, col, n);
            if (uf[ind] < 0) {
                uf[ind] = ind;
                cnt++;

                for (int[] direction : directions) {
                    int nextRow = row + direction[0], nextCol = col + direction[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        int nextInd = getInd(nextRow, nextCol, n);
                        if (uf[nextInd] >= 0 && connect(uf, ind, nextInd)) {
                            cnt--;
                        }
                    }
                }
            }

            res.add(cnt);
        }
        return res;
    }

    private int getParent(int[] uf, int i) {
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }

        return uf[i];
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

    private int getInd(int row, int col, int n) {
        return row * n + col;
    }
}
