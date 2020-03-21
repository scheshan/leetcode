package l79;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/21
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (perm(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean perm(char[][] board, String word, int i, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word.charAt(i)) {
            return false;
        }

        if (i == word.length() - 1) {
            return true;
        }

        char c = board[x][y];
        board[x][y] = ' ';

        if (perm(board, word, i + 1, x - 1, y)) {
            return true;
        }
        if (perm(board, word, i + 1, x + 1, y)) {
            return true;
        }
        if (perm(board, word, i + 1, x, y - 1)) {
            return true;
        }
        if (perm(board, word, i + 1, x, y + 1)) {
            return true;
        }

        board[x][y] = c;
        return false;
    }
}
