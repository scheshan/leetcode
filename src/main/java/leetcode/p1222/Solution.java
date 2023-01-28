package leetcode.p1222;

import java.util.*;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/28
 */
public class Solution {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] directions = new int[][]{
                {0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}
        };
        boolean[][] board = new boolean[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] dir : directions) {
            int x = king[0] + dir[0];
            int y = king[1] + dir[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y]) {
                    res.add(Arrays.asList(x, y));
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return res;
    }
}
