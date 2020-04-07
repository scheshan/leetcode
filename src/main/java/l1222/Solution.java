package l1222;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/7
 */
public class Solution {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] grid = new int[8][8];
        grid[king[0]][king[1]] = 1;

        for (int[] queen : queens) {
            grid[queen[0]][queen[1]] = 2;
        }

        int i = king[0];
        int j = king[1];

        List<List<Integer>> res = new LinkedList<>();
        move(grid, res, i, j, -1, 0);
        move(grid, res, i, j, 1, 0);
        move(grid, res, i, j, 0, -1);
        move(grid, res, i, j, 0, 1);
        move(grid, res, i, j, -1, -1);
        move(grid, res, i, j, -1, 1);
        move(grid, res, i, j, 1, -1);
        move(grid, res, i, j, 1, 1);

        return res;
    }

    private void move(int[][] grid, List<List<Integer>> res, int i, int j, int x, int y) {
        while (true) {
            i += x;
            j += y;

            if (i < 0 || j < 0 || i >= 8 || j >= 8) {
                return;
            }

            if (grid[i][j] == 2) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
    }
}
