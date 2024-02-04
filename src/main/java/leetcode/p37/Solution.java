package leetcode.p37;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/2/4
 */
public class Solution {

    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] grids = new int[9];

    public void solveSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    int n = 1 << (board[row][col] - '0');

                    rows[row] |= n;
                    cols[col] |= n;
                    grids[gridIndex(row, col)] |= n;
                }
            }
        }

        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int i, int j) {
        if (i == board.length) {
            return true;
        }

        int nextI = i, nextJ = j + 1;
        if (nextJ == board[i].length) {
            nextJ = 0;
            nextI++;
        }

        char ch = board[i][j];
        if (ch == '.') {
            for (int k = 1; k <= 9; k++) {
                int n = 1 << k;

                if ((rows[i] & n) == 0 && (cols[j] & n) == 0 && (grids[gridIndex(i, j)] & n) == 0) {
                    rows[i] |= n;
                    cols[j] |= n;
                    grids[gridIndex(i, j)] |= n;
                    board[i][j] = (char) ('0' + k);

                    if (backtracking(board, i, j)) {
                        return true;
                    }

                    rows[i] ^= n;
                    cols[j] ^= n;
                    grids[gridIndex(i, j)] ^= n;
                    board[i][j] = '.';
                }
            }
        } else {
            return backtracking(board, nextI, nextJ);
        }
        return false;
    }

    private int gridIndex(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }
}
