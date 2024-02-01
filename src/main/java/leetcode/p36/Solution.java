package leetcode.p36;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/1
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grids = new int[9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int n = 1 << (board[row][col] - '0');

                if ((rows[row] & n) != 0) {
                    return false;
                }
                if ((cols[col] & n) != 0) {
                    return false;
                }
                if ((grids[gridIndex(row, col)] & n) != 0) {
                    return false;
                }
                rows[row] |= n;
                cols[col] |= n;
                grids[gridIndex(row, col)] |= n;
            }
        }

        return true;
    }

    private int gridIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
