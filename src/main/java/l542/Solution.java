package l542;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/15
 */
public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        List<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;

            List<int[]> list = queue;
            queue = new LinkedList<>();

            for (int[] p : list) {
                add(queue, matrix, p[0] - 1, p[1], distance);
                add(queue, matrix, p[0] + 1, p[1], distance);
                add(queue, matrix, p[0], p[1] - 1, distance);
                add(queue, matrix, p[0], p[1] + 1, distance);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -matrix[i][j];
            }
        }
        return matrix;
    }

    private void add(List<int[]> queue, int[][] matrix, int i, int j, int distance) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] <= 0) {
            return;
        }

        matrix[i][j] = -distance;
        queue.add(new int[]{i, j});
    }
}
