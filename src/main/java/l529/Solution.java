package l529;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/14
 */
public class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            dfs(board, click[0], click[1], click);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j, int[] click) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'E') {
            return;
        }

        int count = 0;
        count += count(board, i - 1, j - 1);
        count += count(board, i - 1, j);
        count += count(board, i - 1, j + 1);
        count += count(board, i, j - 1);
        count += count(board, i, j + 1);
        count += count(board, i + 1, j - 1);
        count += count(board, i + 1, j);
        count += count(board, i + 1, j + 1);
        if (count == 0) {
            board[i][j] = 'B';

            dfs(board, i - 1, j - 1, click);
            dfs(board, i - 1, j, click);
            dfs(board, i - 1, j + 1, click);
            dfs(board, i, j - 1, click);
            dfs(board, i, j + 1, click);
            dfs(board, i + 1, j - 1, click);
            dfs(board, i + 1, j, click);
            dfs(board, i + 1, j + 1, click);
        } else {
            board[i][j] = (char) (count + '0');
        }
    }

    private int count(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'M') {
            return 0;
        }

        return 1;
    }
}
