package leetcode.p130;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public void solve(char[][] board) {
        boolean[][] grid = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0, grid);
            dfs(board, i, board[i].length - 1, grid);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            dfs(board, 0, i, grid);
            dfs(board, board.length - 1, i, grid);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (!grid[row][col] && board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, boolean[][] grid) {
        if (grid[row][col] || board[row][col] != 'O') {
            return;
        }

        grid[row][col] = true;
        if (row > 0) {
            dfs(board, row - 1, col, grid);
        }
        if (row < board.length - 1) {
            dfs(board, row + 1, col, grid);
        }
        if (col > 0) {
            dfs(board, row, col - 1, grid);
        }
        if (col < board[row].length - 1) {
            dfs(board, row, col + 1, grid);
        }
    }
}
