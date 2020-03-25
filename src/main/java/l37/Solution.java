package l37;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/25
 */
public class Solution {

    public void solveSudoku(char[][] board) {
        perm(board, 0, 0);
    }

    private boolean perm(char[][] board, int i, int j) {
        if (i >= board.length) {
            return true;
        }

        int nextI = i, nextJ = j;
        if (j < board.length - 1) {
            nextJ = j + 1;
        } else {
            nextI++;
            nextJ = 0;
        }


        if (board[i][j] != '.') {
            return perm(board, nextI, nextJ);
        } else {
            boolean match = false;
            for (int n = 1; n <= 9; n++) {
                if (valid(board, i, j, n)) {
                    board[i][j] = (char) (n + '0');
                    match = perm(board, nextI, nextJ);
                    if (match) {
                        break;
                    }
                    board[i][j] = '.';
                }
            }
            return match;
        }
    }

    private boolean valid(char[][] board, int i, int j, int n) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] - '0' == n && k != j) {
                return false;
            }
            if (board[k][j] - '0' == n && k != i) {
                return false;
            }
        }

        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int k = row; k < row + 3; k++) {
            for (int l = col; l < col + 3; l++) {
                if (k != i && l != j && board[k][l] - '0' == n) {
                    return false;
                }
            }
        }

        return true;
    }
}
