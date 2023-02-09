package leetcode.p994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/10
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        int res = 0;
        int total = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    total++;
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.remove();
                int row = arr[0], col = arr[1];
                if (row > 0 && addQueue(queue, grid, row - 1, col)) {
                    total--;
                }
                if (row < grid.length - 1 && addQueue(queue, grid, row + 1, col)) {
                    total--;
                }
                if (col > 0 && addQueue(queue, grid, row, col - 1)) {
                    total--;
                }
                if (col < grid[row].length - 1 && addQueue(queue, grid, row, col + 1)) {
                    total--;
                }
            }
            res++;
        }
        return total == 0 ? res - 1 : -1;
    }

    private boolean addQueue(Queue<int[]> queue, int[][] grid, int row, int col) {
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            queue.add(new int[]{row, col});
            return true;
        }
        return false;
    }
}
