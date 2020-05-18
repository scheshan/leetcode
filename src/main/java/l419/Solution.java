package l419;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/5/19
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int res = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    res++;

                    if (i > 0 && board[i - 1][j] == 'X') {
                        res--;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        res--;
                    }
                }
            }
        }
        return res;
    }
}
