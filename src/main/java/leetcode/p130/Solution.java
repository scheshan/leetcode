package leetcode.p130;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/24
 */
public class Solution {

    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[i].length - 1] == 'O') {
                dfs(board, i, board[i].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = ' ';
        if (i > 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j < board[i].length - 1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
}
