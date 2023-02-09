package leetcode.p37;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/9
 */
public class Solution {

    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] blocks = new int[9];

    public void solveSudoku(char[][] board) {
        List<int[]> points = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    int n = board[row][col] - '0';
                    rows[row] |= 1 << n;
                    cols[col] |= 1 << n;
                    blocks[getBlockInd(row, col)] |= 1 << n;
                } else {
                    points.add(new int[]{row, col});
                }
            }
        }

        backtrack(board, points, 0);
    }

    private boolean backtrack(char[][] board, List<int[]> points, int ind) {
        if (ind == points.size()) {
            return true;
        }

        int row = points.get(ind)[0];
        int col = points.get(ind)[1];

        for (int i = 1; i <= 9; i++) {
            int n = 1 << i;
            if ((rows[row] & n) != 0 || (cols[col] & n) != 0 || (blocks[getBlockInd(row, col)] & n) != 0) {
                continue;
            }

            rows[row] |= n;
            cols[col] |= n;
            blocks[getBlockInd(row, col)] |= n;
            board[row][col] = (char) ('0' + i);
            if (backtrack(board, points, ind + 1)) {
                return true;
            }
            board[row][col] = '.';
            rows[row] ^= n;
            cols[col] ^= n;
            blocks[getBlockInd(row, col)] ^= n;
        }
        return false;
    }

    private int getBlockInd(int row, int col) {
        return (row / 3 * 3) + (col / 3);
    }
}
