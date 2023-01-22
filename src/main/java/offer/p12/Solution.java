package offer.p12;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/23
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            visit[i] = new boolean[board[i].length];
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, row, col, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int i, boolean[][] visit) {
        if (board[row][col] != word.charAt(i)) {
            return false;
        }
        visit[row][col] = true;
        if (i == word.length() - 1) {
            return true;
        }

        boolean res = false;
        if (row > 0 && !visit[row - 1][col]) {
            res = res || dfs(board, row - 1, col, word, i + 1, visit);
        }
        if (row < board.length - 1 && !visit[row + 1][col]) {
            res = res || dfs(board, row + 1, col, word, i + 1, visit);
        }
        if (col > 0 && !visit[row][col - 1]) {
            res = res || dfs(board, row, col - 1, word, i + 1, visit);
        }
        if (col < board[row].length - 1 && !visit[row][col + 1]) {
            res = res || dfs(board, row, col + 1, word, i + 1, visit);
        }
        visit[row][col] = false;
        return res;
    }
}
