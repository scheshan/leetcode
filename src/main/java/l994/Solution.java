package l994;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/4
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        int days = 0;

        List<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            days++;

            List<int[]> list = queue;
            queue = new LinkedList<>();
            for (int[] cell : list) {
                visit(grid, cell[0] - 1, cell[1], queue);
                visit(grid, cell[0] + 1, cell[1], queue);
                visit(grid, cell[0], cell[1] - 1, queue);
                visit(grid, cell[0], cell[1] + 1, queue);
            }

            if (queue.isEmpty()) {
                days--;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return days;
    }

    private void visit(int[][] grid, int i, int j, List<int[]> list) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        list.add(new int[]{i, j});
    }
}
