package leetcode.p1654;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Solution
 *
 * @author heshan
 * @date 2023/3/4
 */
public class Solution {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> visit = new HashSet<>();
        for (int num : forbidden) {
            visit.add(num);
        }

        Queue<int[]> queue = new LinkedList<>();
        addQueue(queue, new int[]{0, 1}, visit, 0, 4000);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.remove();
                if (arr[0] == x) {
                    return res;
                }

                addQueue(queue, new int[]{arr[0] + a, 1}, visit, 0, 6000);

                if (arr[1] != -1) {
                    addQueue(queue, new int[]{arr[0] - b, -1}, visit, 0, 6000);
                }
            }
            res++;
        }

        return -1;
    }

    private void addQueue(Queue<int[]> queue, int[] arr, Set<Integer> visit, int min, int max) {
        if (arr[0] < min || arr[0] > max || visit.contains(arr[0])) {
            return;
        }
        if (arr[1] > 0) {
            visit.add(arr[0]);
        }
        queue.add(arr);
    }
}
