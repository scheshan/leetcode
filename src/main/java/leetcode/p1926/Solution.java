package leetcode.p1926;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/27
 */
public class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        Queue<int[]> queue = new LinkedList<>();
        addQueue(maze, entrance[0], entrance[1], queue);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                if ((p[0] == 0 || p[0] == maze.length - 1 || p[1] == 0 || p[1] == maze[p[0]].length - 1) && (p[0] != entrance[0] || p[1] != entrance[1])) {
                    return step;
                }

                for (int[] dir : directions) {
                    addQueue(maze, p[0] + dir[0], p[1] + dir[1], queue);
                }
            }
            step++;
        }
        return -1;
    }

    private void addQueue(char[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != '.') {
            return;
        }

        grid[row][col] = '+';
        queue.add(new int[]{row, col});
    }
}
