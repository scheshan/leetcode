package leetcode.p286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/2/13
 */
public class Solution {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new int[]{row, col});
                }
            }
        }

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.remove();
                if (arr[0] > 0) {
                    addQueue(queue, arr[0] - 1, arr[1], rooms, step);
                }
                if (arr[0] < rooms.length - 1) {
                    addQueue(queue, arr[0] + 1, arr[1], rooms, step);
                }
                if (arr[1] > 0) {
                    addQueue(queue, arr[0], arr[1] - 1, rooms, step);
                }
                if (arr[1] < rooms[arr[0]].length - 1) {
                    addQueue(queue, arr[0], arr[1] + 1, rooms, step);
                }
            }
            step++;
        }
    }

    private void addQueue(Queue<int[]> queue, int row, int col, int[][] rooms, int step) {
        if (rooms[row][col] != 2147483647) {
            return;
        }
        rooms[row][col] = step;
        queue.add(new int[]{row, col});
    }
}
