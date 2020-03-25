package l36;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !valid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean valid(char[][] board, int i, int j, char n) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == n && k != j) {
                return false;
            }
            if (board[k][j] == n && k != i) {
                return false;
            }
        }

        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int k = row; k < row + 3; k++) {
            for (int l = col; l < col + 3; l++) {
                if (k != i && l != j && board[k][l] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}
