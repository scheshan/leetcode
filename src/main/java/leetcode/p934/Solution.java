package leetcode.p934;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/28
 */
public class Solution {

    private int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = init(grid);

        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                if (grid[p[0]][p[1]] == -1) {
                    return res;
                }

                for (int[] dir : directions) {
                    addQueue(grid, p[0] + dir[0], p[1] + dir[1], queue);
                }
            }

            res++;
        }

        return res;
    }

    private Queue<int[]> init(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    return queue;
                }
            }
        }
        return queue;
    }

    private void dfs(int[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return;
        }

        grid[row][col] = -2;
        queue.add(new int[]{row, col});

        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], queue);
        }
    }

    private void addQueue(int[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] < 0) {
            return;
        }

        grid[row][col] -= 2;
        queue.add(new int[]{row, col});
    }
}
