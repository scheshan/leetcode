package leetcode.p2326;

import common.ListNode;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/1/16
 */
public class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i] = new int[n];
        }

        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                head = fillValue(res, r1, i, head);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                head = fillValue(res, i, c2, head);
            }
            if (r1 < r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    head = fillValue(res, r2, i, head);
                }
            }
            if (c1 < c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    head = fillValue(res, i, c1, head);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }

        return res;
    }

    private ListNode fillValue(int[][] board, int row, int col, ListNode node) {
        if (node == null) {
            board[row][col] = -1;
        } else {
            board[row][col] = node.val;
            node = node.next;
        }
        return node;
    }
}
