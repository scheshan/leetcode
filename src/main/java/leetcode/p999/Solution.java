package leetcode.p999;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/14
 */
public class Solution {

    public int numRookCaptures(char[][] board) {
        int r = 0;
        int c = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'R') {
                    r = row;
                    c = col;
                    break;
                }
            }
        }

        int res = 0;
        for (int row = r + 1; row < board.length; row++) {
            if (board[row][c] != '.') {
                if (board[row][c] == 'p') {
                    res++;
                }
                break;
            }
        }
        for (int row = r - 1; row >= 0; row--) {
            if (board[row][c] != '.') {
                if (board[row][c] == 'p') {
                    res++;
                }
                break;
            }
        }
        for (int col = c + 1; col < board[r].length; col++) {
            if (board[r][col] != '.') {
                if (board[r][col] == 'p') {
                    res++;
                }
                break;
            }
        }
        for (int col = c - 1; col >= 0; col--) {
            if (board[r][col] != '.') {
                if (board[r][col] == 'p') {
                    res++;
                }
                break;
            }
        }
        return res;
    }
}
