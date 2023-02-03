package leetcode.p542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/3
 */
public class Solution {

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                int row = p[0], col = p[1];
                res[row][col] = step;

                if (row > 0 && mat[row - 1][col] != 0) {
                    addQueue(mat, row - 1, col, queue);
                }
                if (row < mat.length - 1 && mat[row + 1][col] != 0) {
                    addQueue(mat, row + 1, col, queue);
                }
                if (col > 0 && mat[row][col - 1] != 0) {
                    addQueue(mat, row, col - 1, queue);
                }
                if (col < mat[row].length - 1 && mat[row][col + 1] != 0) {
                    addQueue(mat, row, col + 1, queue);
                }
            }

            step++;
        }

        return res;
    }

    private void addQueue(int[][] mat, int row, int col, Queue<int[]> queue) {
        mat[row][col] = 0;
        queue.add(new int[]{row, col});
    }
}
