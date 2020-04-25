package l286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2020/4/25
 */
public class Solution {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.remove();
                if (step < rooms[point[0]][point[1]]) {
                    rooms[point[0]][point[1]] = step;
                }
                addQueue(queue, rooms, point[0] - 1, point[1]);
                addQueue(queue, rooms, point[0] + 1, point[1]);
                addQueue(queue, rooms, point[0], point[1] - 1);
                addQueue(queue, rooms, point[0], point[1] + 1);
            }

            step++;
        }
    }

    private void addQueue(Queue<int[]> queue, int[][] rooms, int i, int j) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] < 2147483647) {
            return;
        }

        queue.add(new int[]{i, j});
    }

    public static void main(String[] args) {
        new Solution().wallsAndGates(new int[][]{
                new int[]{2147483647, -1, 0, 2147483647},
                new int[]{2147483647, 2147483647, 2147483647, -1},
                new int[]{2147483647, -1, 2147483647, -1},
                new int[]{0, -1, 2147483647, 2147483647}
        });
    }
}
