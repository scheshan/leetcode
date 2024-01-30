package leetcode.p994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0, step = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    cnt++;
                }
            }
        }

        while (!queue.isEmpty() && cnt > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();
                if (addQueue(queue, p[0] - 1, p[1], grid)) cnt--;
                if (addQueue(queue, p[0] + 1, p[1], grid)) cnt--;
                if (addQueue(queue, p[0], p[1] - 1, grid)) cnt--;
                if (addQueue(queue, p[0], p[1] + 1, grid)) cnt--;
            }
            step++;
        }

        return cnt == 0 ? step : -1;
    }

    private boolean addQueue(Queue<int[]> queue, int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return false;
        }
        grid[row][col] = 2;
        queue.add(new int[]{row, col});
        return true;
    }
}
