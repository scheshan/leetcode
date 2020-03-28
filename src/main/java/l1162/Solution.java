package l1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/3/29
 */
public class Solution {

    public int maxDistance(int[][] grid) {
        int res = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            Queue<int[]> list = queue;
            queue = new LinkedList<>();

            for (int[] point : list) {
                addQueue(queue, grid, point[0] - 1, point[1]);
                addQueue(queue, grid, point[0] + 1, point[1]);
                addQueue(queue, grid, point[0], point[1] - 1);
                addQueue(queue, grid, point[0], point[1] + 1);
            }
            if (queue.isEmpty()) {
                break;
            }

            res++;
        }

        return res == 1 ? -1 : res - 1;
    }

    private void addQueue(Queue<int[]> queue, int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 0) {
            return;
        }

        grid[i][j] = 1;
        queue.add(new int[]{i, j});
    }

    public static void main(String[] args) {
        int res = new Solution().maxDistance(new int[][]{new int[]{0}});
        System.out.println(res);
    }
}
