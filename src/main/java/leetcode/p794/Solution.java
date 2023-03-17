package leetcode.p794;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/17
 */
public class Solution {

    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    x++;
                } else if (board[i].charAt(j) == 'O') {
                    o++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i) && board[0].charAt(i) != ' ') {
                if (board[0].charAt(i) == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2) && board[i].charAt(0) != ' ') {
                if (board[i].charAt(0) == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2) && board[0].charAt(0) != ' ') {
            if (board[0].charAt(0) == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0) && board[2].charAt(0) != ' ') {
            if (board[0].charAt(2) == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }

        if (xWin && oWin) {
            return false;
        }

        if (xWin) {
            return x >= o && x <= o + 1;
        } else if (oWin) {
            return x == o;
        } else {
            return x >= o && x <= o + 1;
        }
    }
}
