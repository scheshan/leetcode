package leetcode.p1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int maxDistance(int[][] grid) {
        int res = -1;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                addQueue(grid, p[0] - 1, p[1], queue);
                addQueue(grid, p[0] + 1, p[1], queue);
                addQueue(grid, p[0], p[1] - 1, queue);
                addQueue(grid, p[0], p[1] + 1, queue);
            }
            res++;
        }

        return res == 0 ? -1 : res;
    }

    private void addQueue(int[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 1) {
            return;
        }
        grid[row][col] = 1;
        queue.add(new int[]{row, col});
    }
}
