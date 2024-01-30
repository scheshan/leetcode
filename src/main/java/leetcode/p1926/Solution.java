package leetcode.p1926;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2024/1/30
 */
public class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visit = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        visit[entrance[0]][entrance[1]] = true;
        queue.add(entrance);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.remove();

                if ((p[0] == 0 || p[1] == 0 || p[0] == maze.length - 1 || p[1] == maze[0].length - 1) && (p[0] != entrance[0] || p[1] != entrance[1])) {
                    return step;
                }

                addQueue(queue, p[0] - 1, p[1], maze, visit);
                addQueue(queue, p[0] + 1, p[1], maze, visit);
                addQueue(queue, p[0], p[1] - 1, maze, visit);
                addQueue(queue, p[0], p[1] + 1, maze, visit);
            }
            step++;
        }

        return -1;
    }

    private void addQueue(Queue<int[]> queue, int row, int col, char[][] maze, boolean[][] visit) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
            return;
        }
        if (visit[row][col] || maze[row][col] == '+') {
            return;
        }
        visit[row][col] = true;
        queue.add(new int[]{row, col});
    }
}
