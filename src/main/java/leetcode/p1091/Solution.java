package leetcode.p1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int step = 0;

        int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}
        };

        Queue<int[]> queue = new LinkedList<>();
        addQueue(grid, 0, 0, queue);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                if (p[0] == grid.length - 1 && p[1] == grid[p[0]].length - 1) {
                    return step;
                }

                for (int[] dir : directions) {
                    addQueue(grid, p[0] + dir[0], p[1] + dir[1], queue);
                }
            }
        }

        return -1;
    }

    private void addQueue(int[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[row].length - 1 || grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        queue.add(new int[]{row, col});
    }
}
