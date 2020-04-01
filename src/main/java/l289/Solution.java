package l289;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/2
 */
public class Solution {

    public void gameOfLife(int[][] board) {
        //2: from 0 to 1
        //3: from 1 to 0

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                if (board[i][j] == 1) {
                    for (int i1 = i - 1; i1 <= i + 1; i1++) {
                        for (int j1 = j - 1; j1 <= j + 1; j1++) {
                            if (i1 >= 0 && i1 < board.length && j1 >= 0 && j1 < board[i1].length) {
                                if (i1 == i && j1 == j) {
                                    continue;
                                }
                                if (board[i1][j1] == 1 || board[i1][j1] == 3) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count < 2 || count > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    for (int i1 = i - 1; i1 <= i + 1; i1++) {
                        for (int j1 = j - 1; j1 <= j + 1; j1++) {
                            if (i1 >= 0 && i1 < board.length && j1 >= 0 && j1 < board[i1].length) {
                                if (i1 == i && j1 == j) {
                                    continue;
                                }
                                if (board[i1][j1] == 1 || board[i1][j1] == 3) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][];
        grid[0] = new int[]{0, 1, 0};
        grid[1] = new int[]{0, 0, 1};
        grid[2] = new int[]{1, 1, 1};
        grid[3] = new int[]{0, 0, 0};

        new Solution().gameOfLife(grid);
    }
}
